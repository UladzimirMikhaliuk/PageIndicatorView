package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.WormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class WormDrawer extends BaseDrawer {

    public RectF rect;

    public WormDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
        rect = new RectF();
    }

    public void draw(
            @NonNull Canvas canvas,
            @NonNull Value value,
            int coordinateX,
            int coordinateY) {

        if (!(value instanceof WormAnimationValue)) {
            return;
        }

        WormAnimationValue v = (WormAnimationValue) value;
        int rectStart = v.getRectStart();
        int rectEnd = v.getRectEnd();

        int radius = indicator.getRadius();
        int unselectedColor = indicator.getUnselectedColor();
        int selectedColor = indicator.getSelectedColor();

        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            rect.left = rectStart;
            rect.right = rectEnd;
            rect.top = coordinateY - radius / divider;
            rect.bottom = coordinateY + radius / divider;

        } else {
            rect.left = coordinateX - radius / divider;
            rect.right = coordinateX + radius / divider;
            rect.top = rectStart;
            rect.bottom = rectEnd;
        }

        paint.setColor(unselectedColor);
        float divider = this.divider;
        divider = divider / 2f;
        canvas.drawRect(coordinateX - radius, coordinateY - radius / divider, coordinateX + radius, coordinateY + radius / divider,  paint);

        paint.setColor(selectedColor);
        canvas.drawRect(rect, paint);
    }
}
