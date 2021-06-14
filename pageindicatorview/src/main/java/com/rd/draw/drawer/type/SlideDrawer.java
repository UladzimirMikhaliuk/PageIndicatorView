package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.SlideAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class SlideDrawer extends BaseDrawer {

    public SlideDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(
            @NonNull Canvas canvas,
            @NonNull Value value,
            int coordinateX,
            int coordinateY) {

        if (!(value instanceof SlideAnimationValue)) {
            return;
        }

        SlideAnimationValue v = (SlideAnimationValue) value;
        int coordinate = v.getCoordinate();
        int unselectedColor = indicator.getUnselectedColor();
        int selectedColor = indicator.getSelectedColor();
        int radius = indicator.getRadius();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(selectedColor);

        float strokeWidth = 3f;

        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            canvas.drawCircle(coordinateX - strokeWidth , coordinateY - strokeWidth , radius - strokeWidth , paint);
        } else {
            canvas.drawCircle(coordinateX - strokeWidth , coordinateY - strokeWidth , radius - strokeWidth , paint);
        }

        paint.setColor(unselectedColor);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(coordinateX - strokeWidth , coordinateY - strokeWidth , radius - strokeWidth , paint);
    }
}
