# jobexpenses.py

def main():
    # Input: Read the integer N
    n = int(input().strip())

    total_expense = 0

    # Input: Read the list of N integers representing expenses
    expenses = list(map(int, input().split()))

    # Calculate the sum of negative expenses
    total_expense = sum(x for x in expenses if x < 0)

    # Output: Print the absolute value of total_expense
    print(abs(total_expense))

if __name__ == "__main__":
    main()
