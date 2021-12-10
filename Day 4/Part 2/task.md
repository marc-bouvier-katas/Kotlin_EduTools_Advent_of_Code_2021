# Day 4: Giant Squid - Part Two

https://adventofcode.com/2021/day/4

On the other hand, it might be wise to try a different strategy: let the giant squid win.

You aren't sure how many bingo boards a giant squid could play at once, so rather than waste time counting its arms, the safe thing to do is to **figure out which board will win last** and choose that one. That way, no matter which boards it picks, it will win for sure.

In the above example, the second board is the last to win, which happens after `13` is eventually called and its middle column is completely marked. If you were to keep playing until this point, the second board would have a sum of unmarked numbers equal to `148` for a final score of `148 * 13 = `**`1924`**.

Figure out which board will win last. **Once it wins, what would its final score be?**

Puzzle Input source : https://adventofcode.com/2021/day/4/input

## About spoilers

This lesson does not contain the answer of the real advent of code problem.
I deliberately used half of the puzzle input file lines for the final acceptation test.

**Hence, you won't be spoiled** if you peek the source code of the tests.

## About TDD

If you want to practice Test-Driven-Development, you can write you own tests in the following file : `test/YourOwnTests.kt`