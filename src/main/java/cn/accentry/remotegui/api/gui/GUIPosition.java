package cn.accentry.remotegui.api.gui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GUIPosition {
    public GUIPosition(int value) {
        row = value/10;
        column = value%10;
    }

    public int toValue() {
        return row*10+column;
    }
    int row;
    int column;
}
