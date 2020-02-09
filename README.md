
# Find-an-Anagram-of-a-String-in-Another-String

Challenge at edabit.com: string, validation.

The input of this challenge is only lowercase English letters. Althouhg the maximum length of the anagram is not stated, if it is known, there could be different approaches for the most efficient solution. 

If the maximum length of the anagram is less than 13 chars 
(all letters of the alphabet divided by 2), the challenge could be most efficiently solved
with "SolutionStringBuilder". This follows from the worst case scenario,
where for each substring of the String to be checked:
- a StringBuilder with the anagram has to be initiated (max length less than 13).
- each char in current substring with the lengthg of the anagram (max length less than 13) has to be checked. 
Thus, if the length of the anagram is less than 13 chars, there is a total of less than 26 iterations for each subtring of the String to be checked.

Otherwise, the most efficient way could be "SolutionTwoArrays". Since the length of each of the two arrays is equal to number of letters in the English alphabet, there will be always 26 iterations for each substring of the String to be checked, regardless of the length of the anagram.   
