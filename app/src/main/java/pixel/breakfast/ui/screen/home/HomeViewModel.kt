package pixel.breakfast.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pixel.breakfast.data.repository.MenuRepository
import pixel.breakfast.domain.model.enum.MenuCategoryEnum
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: MenuRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadMenu()
    }

    fun loadMenu() {
        _uiState.update { it.copy(isLoading = true, error = null) }
        viewModelScope.launch {
            repo.fetchMenu()
                .onSuccess { items ->
                    _uiState.update { s ->
                        s.copy(
                            isLoading = false,
                            items = items,
                            visibleItems = items.filter { it.category == s.selectedCategory }
                        )
                    }
                }
                .onFailure { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message ?: "Unknown error") }
                }
        }
    }

    // -------- Page Actions --------
    fun onCategoryClick(category: MenuCategoryEnum) {
        _uiState.update { s ->
            s.copy(
                selectedCategory = category,
                visibleItems = s.items.filter { it.category == category }
            )
        }
    }
}
