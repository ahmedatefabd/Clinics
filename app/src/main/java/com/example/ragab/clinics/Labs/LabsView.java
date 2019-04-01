package com.example.ragab.clinics.Labs;
import java.util.List;
import Model.Sheet_Labs;

public interface LabsView {
    void setSheet_labs(List<Sheet_Labs> sheet_labs);
    void error();
}
