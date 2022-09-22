# Solution 1

Start with a recursive, brute force solution. Simply find all strictly
increasing subsequences from the given array, and determine the longest.

For each element, there are 2 choicess - to include it or to not include it in
the subsequence. Thus, with N elements, there are 2^N possible combinations.

Starting at the first element of the input array, we recurse into 2 instances 
- including the first element or not including it. Subsequent instances start 
at some position i within the array, and are given a subsequence 
array that is being built. If the current element is greater than the last 
element, recurse into the 2 instances, otherwise, since adding it would make the
subsequence no longer strictly increasing, recurse into just one instance where 
the element is skipped.

Return the maximum length subsequence found. Time complexity O(2^N)

# Solution 2

This fits the parameters for a dynamic programming solution. However, trying to
figure out exactly how to create the solution was a bit difficult. I remembered
the fibonacci sequence dynamic programming solution, the key being that recursive
calls to fib(n-1) and fib(n-2) were very reduntant, and instead of recursing
into two instances each iteration, we could instead build bottom up and store
the results of each iteration and reuse that.

However, in this case it isn't as straightforward. There aren't recursive calls
being made that are exactly "duplicative". For the fibonacci recursive solution,
fib(n-1) is eventually going to call fib(n-2), but that was also called initially,
and so the wasted effort is readily apparent.

What I realized is for this problem there is a different type of time
waste - its not eliminating duplicative calls, but rather eliminating
*unnecessary* calls. When considering each element, we do not need to consider
all of the possible strictly inreasing subsequences that can be made from the 
elements before the it. Rather, we just need to consider the *longest* subsequence
that comes before it, where the current element can be added to it.

For example, say we have the array [8, 9, 20, 12]

When we get to 12, we do not need to consider adding it (or not adding it)
to [8], [9], [], [20], [8,9], [9, 20]. Say we found a solution S and it contained 12.
S would clearly **have to** contain the elements [8, 9], otherwise you could easily find
a larger solution than S by adding them to the sequence. So at element 12, instead of
considering 2^2 = 4 possibilities, and then either adding 12 or not adding 12, we
can simply consider the longest sequence that ends with a number smaller than 12
: [8, 9, 12].

So the solution is simply to iterate through each element, and for that index store
the size + 1 of the maximum prior sequence ending with an element less than the current.

We will iterate through all elements i in N, and at each element look back at all
previous elements to determine the max length for i, resulting in O(N^2)

