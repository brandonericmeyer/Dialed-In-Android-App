package com.regis.helloworld.dialedin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.regis.helloworld.dialedin.domain.Workout;
import com.regis.helloworld.dialedin.services.WorkSvcImpl;

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
public class WorkoutSvcImplTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.regis.helloworld.dialedin", appContext.getPackageName());
    }

    @Test
    public void testCreateWorkout() {
        WorkSvcImpl workSvcImpl = new WorkSvcImpl(InstrumentationRegistry.getTargetContext());
        List<String> exercises = new ArrayList<>();
        exercises.add("Bench");
        Workout workout = new Workout("testWorkout", exercises);
        workSvcImpl.remove(workout);
        boolean isCreated = workSvcImpl.create(workout);
        assertEquals(isCreated, true);

    }

    @Test
    public void testRemoveWorkout() {
        WorkSvcImpl workSvcImpl = new WorkSvcImpl(InstrumentationRegistry.getTargetContext());
        List<String> exercises = new ArrayList<>();
        exercises.add("Bench");
        Workout workout = new Workout("testWorkout", exercises);
        workSvcImpl.create(workout);
        boolean isRemoved = workSvcImpl.remove(workout);
        assertEquals(isRemoved, true);

    }

    @Test
    public void testUpdateWorkout() {
        WorkSvcImpl workSvcImpl = new WorkSvcImpl(InstrumentationRegistry.getTargetContext());
        List<String> exercises = new ArrayList<>();
        exercises.add("Bench");
        Workout workout = new Workout("testWorkout", exercises);
        workSvcImpl.create(workout);

        workout.getExercises().add("Fly");
        boolean isUpdated = workSvcImpl.update(workout);
        assertEquals(isUpdated, true);

    }
}
