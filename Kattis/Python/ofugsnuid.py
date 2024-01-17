def reverse_order(n, numbers):
    # Print the list in reverse order
    for i in range(n - 1, -1, -1):
        print(numbers[i])

def main():
    # Input: Read the integer n
    n = int(input().strip())

    # Read n integers and store them in a list
    numbers = [int(input().strip()) for _ in range(n)]

    # Output: Print the list in reverse order
    reverse_order(n, numbers)

if __name__ == "__main__":
    main()
