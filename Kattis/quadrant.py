# quadrantSel.py

def main():
    # Input: Read two integers
    num1 = int(input().strip())
    num2 = int(input().strip())

    # Check the quadrant and print the result
    if num1 >= 1 and num2 >= 1:
        print("1")
    elif num1 <= -1 and num2 >= 1:
        print("2")
    elif num1 <= -1 and num2 <= -1:
        print("3")
    elif num1 >= 1 and num2 <= -1:
        print("4")

if __name__ == "__main__":
    main()
