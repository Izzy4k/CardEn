package com.example.lol.ui.fragment.word

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lol.databinding.FragmentWordBinding
import com.example.lol.domain.word.entity.WordEntity
import com.example.lol.ui.base.BaseFragment
import com.example.lol.ui.bottom_sheet.add_word.AddWordFragment
import com.example.lol.ui.dialog.FullDialog
import com.example.lol.ui.fragment.word.adapter.WordAdapter
import com.example.lol.ui.utils.SwiPet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WordFragment : BaseFragment<FragmentWordBinding>(), AddWordFragment.Result,
    WordAdapter.Result {
    private var category = ""
    private val args: WordFragmentArgs by navArgs()
    private val viewModel: WordViewModel by viewModels()
    private lateinit var wordAdapter: WordAdapter
    private lateinit var swipe: SwiPet
    private lateinit var fullDialog: FullDialog
    override fun getViewBinding(): FragmentWordBinding =
        FragmentWordBinding.inflate(layoutInflater)

    override fun setupUi() {
        initBtn()
        initAdapter()
        initDialog()
    }

    private fun initDialog() {
        fullDialog = FullDialog(requireActivity())
    }

    private fun initAdapter() {
        wordAdapter = WordAdapter(this)
        binding.rvWord.adapter = wordAdapter
    }

    override fun setupObservers() {
        initArgumentListener()
        initWordsListener()
        initSwipeListener()
        initTouchListener()
    }

    private fun initWordsListener() {
        viewModel.getAllWordToCategory(category)
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { handleWords(it) }.launchIn(lifecycleScope)
    }

    private fun handleWords(list: List<WordEntity>) {
        wordAdapter.setList(list)
    }

    private fun initArgumentListener() {
        category = args.category
    }

    private fun initBtn() {
        binding.btnNewWord.setOnClickListener {
            AddWordFragment(this).show(
                requireActivity().supportFragmentManager,
                category
            )
        }
    }

    override fun transNewWord(word: String, category: String) {
        viewModel.createWord(word, category)
    }

    private fun initSwipeListener() {
        swipe = object : SwiPet() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                val wordEntity = wordAdapter.listTemp[pos]
                viewModel.deleteWord(wordEntity)
            }
        }
    }

    private fun initTouchListener() {
        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(binding.rvWord)

    }

    override fun openDialog(image: String, title: String) {
        fullDialog.open(image, title)
    }

}