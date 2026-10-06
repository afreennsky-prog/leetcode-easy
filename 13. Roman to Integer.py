class Solution(object):
    def romanToInt(self, s):
        # Map Roman symbols to their integer values
        roman_map = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        
        total = 0
        
        # Traverse the string
        for i in range(len(s)):
            current_val = roman_map[s[i]]
            
            # If the next value is larger, subtract current value
            if i + 1 < len(s) and current_val < roman_map[s[i + 1]]:
                total -= current_val
            else:
                total += current_val
        
        return total


# Example usage
solution = Solution()
print(solution.romanToInt("III"))      # Output: 3
print(solution.romanToInt("LVIII"))    # Output: 58
print(solution.romanToInt("MCMXCIV"))  # Output: 1994


        
