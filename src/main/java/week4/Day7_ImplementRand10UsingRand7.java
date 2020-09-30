package week4;

import java.util.Random;

public class Day7_ImplementRand10UsingRand7 {

    Random random = new Random();
    public int rand10() {
        int idx,a,b;
        do
        {
            a = rand7();
            b = rand7();
            idx = b + (a - 1) * 7;
        }
        while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    int rand7() {
        return random.nextInt(7) + 1;
    }
}

/*
Algorithm

This solution is based upon Rejection Sampling. The main idea is when you generate,
a number in the desired range,
output that number immediately.
If the number is out of the desired range, reject it and re-sample again.
As each number in the desired range has the same probability of being chosen,
a uniform distribution is produced.

Obviously, we have to run rand7() function at least twice,
as there are not enough numbers in the range of 1 to 10.
By running rand7() twice, we can get integers from 1 to 49 uniformly. Why?


rejectionSamplingTable
A table is used to illustrate the concept of rejection sampling.
Calling rand7() twice will get us row and column index that corresponds,
to a unique position in the table above.
Imagine that you are choosing a number randomly from the table above. I
f you hit a number, you return that number immediately.
If you hit a * , you repeat the process again until you hit a number.

Since 49 is not a multiple of 10, we have to use rejection sampling.
Our desired range is integers from 1 to 40, which we can return the answer immediately.
If not (the integer falls between 41 to 49),
we reject it and repeat the whole process again.
*/
