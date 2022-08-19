# Solution 1

First think through the most simple, brute force solution. To calculate the area between any 2 elements in the array, we simply take the difference of their indicies and multiple by the min of their values

- (j-i) * min(h[i],h[j])

For every element, we can iterate through all the subsequent elements and calculate this, and track the maximum area we find. This results in N * (N/2) operations, thus the time complexity is O(N^2)

This solution works, however is too slow and fails submission do to runtime.

# Solution 2

We need to reduce runtime to at least O(NlogN). O(N) has to be the lower bounds.
How can we reduce second loop? Formula is (j - i) * min(height).

the (j - i) part is fixed, its just the distance between the indicies, can we
take advantage of that somehow?

Perhaps we can use upper bounds from the problem specification. (j-i) has (n-1) unique values,
and in the problem description the maximum height is 10^4 = 10,000. So the maximum number of unique areas is
(n-1) * 10,000.

First thing coming to mind is to use a hashtable or array to store all possible unique areas, iterate through the array in the same brute force manner as in solution 1 but stop when you have filled the hashtable. However this won't work, as you are not guaranteed to see  all unique areas at any point while iterating, so the runtime would still be O(N^2).

Perhaps we can instead loop through the unique number of areas starting with the maximum and do a faster than O(N) lookup to determine if that area exists in the array.

How to do this lookup? Must be something with a hashtable...

No, we dont need a faster than O(N) lookup, since the outer loop will be constant time. Lookup in O(N) is easy :

- begin from max area and for each element in height[], calculate the quotient of the area / height[i]
- check that this quotient is an integer
- check if there is an element height[i + quotient] that is greater than or equal to height[i]
- if these two elements exists, return max area, otherwise decrememnt the area and repeat

This would result in a maximum of (max area) * (n-1) operations, thus O(N) runtime

This solution works for some inputs, but the inner loop doesn't treat the elements sequentially, we need to look backwards as well

# Solution 3

Just look backwards too.

I believe this solution works, but it still fails on runtime even though it is O(N). Must be a faster solution they are looking for, though honestly I feel like this solution is pretty good.

# Solution 4

You have to consider every single element, so the solution has to be O(N).

You can begin at the start and end of the array and keep a pointer at each index, 0 and n-1, and calculate and save the area. Then you can increment the pointer of whichever side has the smaller height, and keep the other pointer the same, calculate the area and save it if its larger than the current max area, and repeat. So for example if the right height is 10 and the left is 8, then the left pointer is now 1 and the right is still n-1.

The reason you can do this is as follows. Denote C(i,j) as the area of the container made by the elements at indicies i and j where i < j. If h[i] < h[j], any container created by i=0 and any elements less than j will be STRICTLY SMALLER than C(0,n-1). This is because any of these such containers could have a MAX height of h[i], and it would have a width less than n-1.

Therefore, it is pointless to consider the index with the smaller height as a candidate, so we keep the pointer at the index with the larger height and check other options coming from the left. This rule can be applied at every combination as you go through the list, until you reach the final two inicies which are x and x+1.