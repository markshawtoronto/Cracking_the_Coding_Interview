package com.CrackingTheCodingInterview;
import java.awt.geom.Point2D;
import java.util.*;
import java.awt.*;

// Chapter Introduction
class SieveofEratosthenes
{
    public static void main(String[] args)
    {
        SieveofEratosthenes soe = new SieveofEratosthenes();

        boolean[] primes_array = soe.SieveOfEratosthenes(100);
    }

    // The Sieve of Erosthenes calculates prime numbers. It takes advantage of the fact that all numbers prime * k are not prime, to "skip" checking those numbers.
    boolean[] SieveOfEratosthenes(int max)
    {
        boolean[] flags = new boolean[max + 1];
        int count = 0;

        // initialize
        for (int i = 2; i < max; i++)
        {
            // Set all "primes" to true by default
            flags[i] = true;
        }
        // 0 and 1 are not prime numbers
        flags[0] = false;
        flags[1] = false;

        int prime = 2;
        while (prime <= Math.sqrt(max))
        {
            // Cross off any remaining multiples of prime
            crossOff(flags, prime);

            // Find next flag value which is still true
            prime = getNextPrime(flags, prime);

            if (prime >= flags.length)
            {
                break;
            }
        }

        return flags;
    }

    void crossOff(boolean[] flags, int prime)
    {
        // Cross off remaining multiples of this prime.
        // Start with prime * prime, because any value k * prime where k < prime would already be crossed off prior in the loop
        for (int i = prime * prime; i < flags.length; i += prime)
        {
            flags[i] = false;
        }
    }

    int getNextPrime(boolean[] flags, int prime)
    {
        int next = prime + 1;
        while (next < flags.length && !flags[next])
        {
            next++;
        }

        return next;
    }
}

// 7.3 Determine if two lines intersect
class Line
{
    double slope;
    double intercept;
    double epsilon = 0.00001; // Cutoff point for double comparisons

    public Line(double s, double i)
    {
        slope = s;
        intercept = i;
    }

    public boolean intersect(Line l1, Line l2)
    {
        // We'd like to check if the slopes do not exactly equal.
        // The limitation of storing slopes as a float means that we must determine some cut off point, however
        if (Math.abs(l1.slope - l2.slope) > 0.000001)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    boolean is_equal(Line line)
    {
        if ((line.slope - this.slope) < epsilon && (line.intercept - this.intercept) < epsilon)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

// 7.4 Implement multiply, subtract and divide operations for integers.
// Use only the add operator.
class int_math
{
    public int multiply(int n1, int n2)
    {
        int output = 0;
        int incr;
        if (n2 < 0)
        {
            incr = negate(n1);
        }
        else
        {
            incr = n1;
        }
        for (int i = 0; i < n2 + 1; i++)
        {
            output += incr;
        }

        return output;
    }

    public int divide(int numerator, int divisor)
    {
        int product = 0;
        int output = 0;
        while (product + divisor <= numerator)
        {
            product += divisor;
            output++;
        }

        // Determine sign
        if (numerator < 0 && divisor < 0)
        {
            return output;
        }
        else if (numerator > 0 && divisor > 0)
        {
            return output;
        }
        else
        {
            return negate(output);
        }
    }

    public int negate(int n)
    {
        int neg = 0;
        int incr;
        if (n < 0)
        {
            incr = 1;
        }
        else
        {
            incr = -1;
        }

        while (n != 0)
        {
            neg += incr;
            n += incr;
        }

        return neg;
    }

    public int subtract(int n1, int n2)
    {
        return n1 + negate(n2);
    }
}

// 7.5 Two squares lie on a cartesian plane. Compute the line which divides both squares evenly in half
// Here, I define the line to be a slope and y intercept.
// Basic idea:
/**
        +
        |
        |    +------+ +------+
        |    |      | |      |
+---------------------------------------+
        |    |      | |      |
        |    +------+ +------+
        |
        |
+----------------------------------------+
        |
        |
        +
**/
class Square
{
    public static void main(String[] input)
    {
        Square sq = new Square(1.0, 2.0, 1.0);
        Square other_sq = new Square(2.0, 2.0, 1.0);

        Line intersecting_line = sq.cut(other_sq);
    }

    double left;
    double right;
    double top;
    double bottom;

    public Square(double left, double top, double size)
    {
        this.left = left;
        this.right = left + size;
        this.top = top;
        this.bottom = top + size;
    }

    public Point2D.Double middle()
    {
        return new Point2D.Double((this.left + this.right) / 2,
                (this.top + this.bottom) / 2);
    }

    public Line cut(Square other_sq)
    {
        // Calculate the slope required
        Point2D.Double other_middle = other_sq.middle();
        Point2D.Double this_middle = this.middle();
        double slope = (other_middle.y - this_middle.y) / (other_middle.x - this_middle.x);

        // Calculate the y intercept required
        // y1 + y2 - m(x1 + x2) = 2b
        double y_intercept = ((other_middle.y + this_middle.y) - slope * (other_middle.x + this_middle.x)) / 2;

        return new Line(slope, y_intercept);
    }
}

// 7.6 Given a 2D Graph with points on it, find a line which passes the most number of points.
class line_intersect
{
    public static void main(String[] input)
    {
        // Create some sample points, with a clear line that intersects them all
        ArrayList<Point2D.Double> set = new ArrayList<Point2D.Double>();

        set.add(new Point2D.Double(1.0, 1.0));
        set.add(new Point2D.Double(2.0, 2.0));
        set.add(new Point2D.Double(3.0, 3.0));

        line_intersect li = new line_intersect(set);
        Line output = li.compute_line();
    }

    ArrayList<Point2D.Double> points;

    public static double epsilon = 0.000001; // Cutoff point for double comparisons

    public line_intersect(ArrayList<Point2D.Double> input)
    {
        this.points = input;
    }

    public Line compute_line()
    {
        // Determine slope by subtracting the coordinates of every point to find the most common slope.
        // Use a HashMap to store number of times each slope occurs.
        // Only one slope will be selected in the end.
        HashMap<Double, ArrayList<Line>> slope_list = new HashMap<Double, ArrayList<Line>>();

        int max = 0;
        Line best_line = null;
        for (int i = 0; i < this.points.size(); i++)
        {
            // Requires double for loop, since we must do every comparison here
            for (int k = i+1; k < this.points.size(); k++)
            {
                Point2D.Double p1 = this.points.get(i);
                Point2D.Double p2 = this.points.get(k);

                // Calculate slope
                if (p1 != p2)
                {
                    Double slope = (p2.y - p1.y) / (p2.x - p1.x);

                    // Calculate the y intercept required
                    // y1 + y2 - m(x1 + x2) = 2b
                    double y_intercept = ((p1.y + p2.y) - slope * (p1.x + p2.x)) / 2;

                    Line new_line = new Line(slope, y_intercept);
                    insert_line(slope_list, new_line);
                    int count = count_equivalent_lines(slope_list.get(slope), new_line);
                    if (count > max)
                    {
                        max = count;
                        best_line = new_line;
                    }
                }
            }
        }

        return best_line;
    }

    void insert_line(HashMap<Double, ArrayList<Line>> slope_list, Line line)
    {
        ArrayList<Line> lines = null;
        double key = line_intersect.floor_to_nearest_epsilon(line.slope);
        if (!slope_list.containsKey(key))
        {
            lines = new ArrayList<Line>();
            lines.add(line);
            slope_list.put(line.slope, lines);
        }
        else
        {
            lines = slope_list.get(key);
            lines.add(line);
        }
    }

    public static double floor_to_nearest_epsilon(double slope)
    {
        int r = (int) (slope / epsilon);
        return (double) r * epsilon;
    }

    int count_equivalent_lines(ArrayList<Line> line_list, Line line)
    {
        if (line_list == null) return 0;
        int count = 0;

        for (Line each_line : line_list)
        {
            if (each_line.is_equal(line))
            {
                count++;
            }
        }

        return count;
    }
}

class kth_prime
{
    public static void main(String[] input)
    {
        kth_prime kp = new kth_prime();

        int a = kp.kth_prime_factor(10);

        System.out.println(a);
    }

    // 7.7 - Design an algorithm to find the kth number such that the only prime factors are 3, 5, 7
    public int kth_prime_factor(int k)
    {
        // I'll want to employ something similar to the sieve of erosthenes, but I won't know what length to expect I must test
        // A number has only the prime factors 3, 5, 7, if it is a result of 3^x * 5^y * 7^z.

        // Optimization = use a queue system to limit what need be tested. Use a Java priorityQueue, this will let us determine how to remove the lowest value each time.
        PriorityQueue<Integer> list = new PriorityQueue<Integer>();

        // Initialize
        int val = 1;
        add_products_to_queue(list, 1);

        for (int i = 0; i < k; i++) // Perform k times to get the kth smallest factor of primes 3,5,7.
        {
            val = remove_min(list);
            add_products_to_queue(list, val);
        }
        return val;
    }

    public void add_products_to_queue(PriorityQueue<Integer> input, int i)
    {
        input.add(i * 3);
        input.add(i * 5);
        input.add(i * 7);
    }

    public Integer remove_min(PriorityQueue<Integer> q)
    {
        boolean more_instances = true;
        int output = q.remove();
        while (more_instances)
        {
            // This must be the lowest value, because it's a priority queue.
            // However, there may be more than one instance in the queue. Each instance must be removed as well.
            if (output == q.peek())
            {
                output = q.remove();
            }
            else
            {
                more_instances = false;
            }
        }

        return output;
    }
}

