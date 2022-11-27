package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenJobDescByName() {
        Job jobOne = new Job("Reboot server", 3);
        Job jobTwo = new Job("Impl task", 1);
        Job jobThree = new Job("Fix bugs", 2);
        List<Job> jobs = Arrays.asList(jobOne, jobTwo, jobThree);
        List<Job> expected = Arrays.asList(jobOne, jobTwo, jobThree);
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByName() {
        Job jobOne = new Job("Reboot server", 3);
        Job jobTwo = new Job("Impl task", 1);
        Job jobThree = new Job("Fix bugs", 2);
        List<Job> jobs = Arrays.asList(jobOne, jobTwo, jobThree);
        List<Job> expected = Arrays.asList(jobThree, jobTwo, jobOne);
        jobs.sort(new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByPriority() {
        Job jobOne = new Job("Reboot server", 3);
        Job jobTwo = new Job("Impl task", 1);
        Job jobThree = new Job("Fix bugs", 2);
        List<Job> jobs = Arrays.asList(jobOne, jobTwo, jobThree);
        List<Job> expected = Arrays.asList(jobOne, jobThree, jobTwo);
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByPriority() {
        Job jobOne = new Job("Reboot server", 3);
        Job jobTwo = new Job("Impl task", 1);
        Job jobThree = new Job("Fix bugs", 2);
        List<Job> jobs = Arrays.asList(jobOne, jobTwo, jobThree);
        List<Job> expected = Arrays.asList(jobTwo, jobThree, jobOne);
        jobs.sort(new JobAscByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenCompatorByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}