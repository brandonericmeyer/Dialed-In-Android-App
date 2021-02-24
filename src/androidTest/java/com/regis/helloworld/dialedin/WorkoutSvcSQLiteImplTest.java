package com.regis.helloworld.dialedin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.regis.helloworld.dialedin.domain.Workout;
import com.regis.helloworld.dialedin.services.WorkSvcSQLiteImpl;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class WorkoutSvcSQLiteImplTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.regis.helloworld.dialedin", appContext.getPackageName());
    }

    @Test
    public void testCreateWorkout() {
        WorkSvcSQLiteImpl workSvcSQLiteImpl = new WorkSvcSQLiteImpl(InstrumentationRegistry.getTargetContext());
        List<String> exercises = new ArrayList<>();
        exercises.add("Bench");
        Workout workout = new Workout("testWorkout", exercises);
        workSvcSQLiteImpl.remove(workout);
        boolean isCreated = workSvcSQLiteImpl.create(workout);
        assertEquals(isCreated, true);

    }

    @Test
    public void testRemoveWorkout() {
        WorkSvcSQLiteImpl workSvcSQLiteImpl = new WorkSvcSQLiteImpl(InstrumentationRegistry.getTargetContext());
        List<String> exercises = new ArrayList<>();
        exercises.add("Bench");
        Workout workout = new Workout("testWorkout", exercises);
        workSvcSQLiteImpl.create(workout);
        boolean isRemoved = workSvcSQLiteImpl.remove(workout);
        assertEquals(isRemoved, true);

    }

    @Test
    public void testUpdateWorkout() {
        WorkSvcSQLiteImpl workSvcSQLiteImpl = new WorkSvcSQLiteImpl(InstrumentationRegistry.getTargetContext());
        List<String> exercises = new ArrayList<>();
        exercises.add("Bench");
        Workout workout = new Workout("testWorkout", exercises);
        workSvcSQLiteImpl.create(workout);

        workout.getExercises().add("Fly");
        boolean isUpdated = workSvcSQLiteImpl.update(workout);
        assertEquals(isUpdated, true);

    }
}
