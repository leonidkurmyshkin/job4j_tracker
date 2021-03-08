package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByName() {
        Job job1 = new Job("First task", 5);
        Job job2 = new Job("Second task", 1);
        assertThat(new JobAscByName().compare(job1, job2),
                lessThan(0));
        assertThat(new JobDescByName().compare(job1, job2),
                greaterThan(0));
    }

    @Test
    public void whenComparatorByPriority() {
        Job job1 = new Job("First task", 5);
        Job job2 = new Job("Second task", 1);
        assertThat(new JobAscByPriority().compare(job1, job2),
                greaterThan(0));
        assertThat(new JobDescByPriority().compare(job1, job2),
                lessThan(0));
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("First task", 5),
                new Job("First task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("First task", 5),
                new Job("First task", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}