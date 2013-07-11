import java.util.ArrayList;

public class Collatz {
    public static void main(String[] args) {
        int start = 1;
        int upto = 100000;
        ArrayList<CollatzResults> results = new ArrayList<CollatzResults>();

        for (int i = start; i <= upto; i++) {
            CollatzResults collatzresults = new CollatzResults(i, sequenceLength(i));
            results.add(collatzresults);

            System.out.println("Sequence starting at " + collatzresults.getSequenceStart() +
                    " length: " + collatzresults.getSequenceLength());
        }

        // Find the sequences with the maximum counts.
        ArrayList<CollatzResults> answers = maxCollatz(results);

        // Output as we go.
        for (CollatzResults answer : answers) {
            System.out.println("Longest sequence starts at " + answer.getSequenceStart() +
                    " has a length of " + answer.getSequenceLength());

        }
    }

    // Collatz functions.
    public static int sequenceLength(int start) {
        int count = 1;

        while (true) {
            if (start % 2 == 0) {
                start = start / 2;
                count++;
            } else {
                start = 3 * start + 1;
                count++;
            }

            if (start == 1) {
                break;
            }
        }

        return count;
    }

    public static ArrayList<CollatzResults> maxCollatz(ArrayList<CollatzResults> results) {
        int maxCount = 0;

        for (CollatzResults result : results) {
            if (result.getSequenceLength() > maxCount) {
                maxCount = result.getSequenceLength();
            }
        }

        // Find all with sequence length of maxCount
        ArrayList<CollatzResults> candidates = new ArrayList<CollatzResults>();
        for (CollatzResults result : results) {
            if (result.getSequenceLength() == maxCount) {
                candidates.add(result);
            }
        }
        return candidates;
    }
}

// Class to capture the results.
class CollatzResults {
    private int sequenceLength = 0;
    private int sequenceStart = 0;


    public CollatzResults(int sequenceStart, int sequenceLength) {
        this.setSequenceLength(sequenceLength);
        this.setSequenceStart(sequenceStart);
    }

    public int getSequenceLength() {
        return sequenceLength;
    }

    public void setSequenceLength(int sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    public int getSequenceStart() {
        return sequenceStart;
    }

    public void setSequenceStart(int sequenceStart) {
        this.sequenceStart = sequenceStart;
    }
}

