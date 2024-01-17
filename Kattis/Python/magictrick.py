def can_guess_operation_correctly(s):
    # Count the occurrences of each letter in the string
    letter_counts = {}
    for letter in s:
        if letter in letter_counts:
            letter_counts[letter] += 1
        else:
            letter_counts[letter] = 1

    # Check if any letter occurs more than half of the total count
    max_count = max(letter_counts.values())
    total_count = len(s)
    if max_count < 2:
        return 1  # You can guarantee guessing the operation correctly
    else:
        return 0  # You cannot guarantee guessing the operation correctly

def main():
    s = input().strip()  # Input string
    result = can_guess_operation_correctly(s)
    print(result)

if __name__ == "__main__":
    main()
