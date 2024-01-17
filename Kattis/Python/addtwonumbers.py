# sum_of_integers.py

def main():
    # Input: Read two integers separated by a space
    a, b = map(int, input().split())

    # Ensure the values of a and b are within the specified bounds
    if 0 <= a <= 1000000 and 0 <= b <= 1000000:
        # Calculate the sum
        sum_result = a + b

        # Output: Print the sum
        print(sum_result)
    else:
        print("Input values are out of bounds.")

if __name__ == "__main__":
    main()
