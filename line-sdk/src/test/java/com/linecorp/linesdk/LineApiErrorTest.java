package com.linecorp.linesdk;

import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link LineApiError}.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = TestConfig.TARGET_SDK_VERSION)
public class LineApiErrorTest {
    @Test
    public void testParcelable() {
        LineApiError expected = new LineApiError(5, "testMessage");

        Parcel parcel = Parcel.obtain();
        expected.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);

        LineApiError actual = LineApiError.CREATOR.createFromParcel(parcel);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testEquals() {
        LineApiError expected = new LineApiError(5, "testMessage");

        assertTrue(expected.equals(new LineApiError(5, "testMessage")));
        assertFalse(expected.equals(new LineApiError(4, "testMessage")));
        assertFalse(expected.equals(new LineApiError(5, "testMessage2")));
    }
}