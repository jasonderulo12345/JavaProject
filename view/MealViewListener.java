package view;

public interface MealViewListener{
    void onSaveButtonPressed();
    void onDeleteButtonPressed();
    void onCancelButtonPressed();
    void onImageChanged(String imagePath);
}