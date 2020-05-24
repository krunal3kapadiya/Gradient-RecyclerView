package krunal3kapadiya.com.gradientrecyclerview.data;

/**
 * Created by krunal3kapadiya on 8/24/2017.
 */

public class ValueInterpolator
{
    private float mRangeMapFromMin;
    private float mRangeMapToMin;

    private float mScaleFactor;

    public ValueInterpolator(float[] rangeMapFrom, float[] rangeMapTo) {
        this(rangeMapFrom[0], rangeMapFrom[1], rangeMapTo[0], rangeMapTo[1]);
    }

    public ValueInterpolator(float rangeMapFromMin, float rangeMapFromMax, float rangeMapToMin, float rangeMapToMax) {
        mRangeMapFromMin = rangeMapFromMin;
        mRangeMapToMin = rangeMapToMin;

        float rangeMapFromSpan = rangeMapFromMax - rangeMapFromMin;
        float rangeMapToSpan = rangeMapToMax - rangeMapToMin;

        mScaleFactor = rangeMapToSpan / rangeMapFromSpan;
    }

    public float map(float value) {
        return mRangeMapToMin + ((value - mRangeMapFromMin) * mScaleFactor);
    }

}
