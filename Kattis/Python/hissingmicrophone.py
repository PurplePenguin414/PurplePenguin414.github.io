# hiss_check.py

def check_hiss(input_str):
    for i in range(len(input_str) - 1):
        if input_str[i] == 's' and input_str[i + 1] == 's':
            return "hiss"
    return "no hiss"

def main():
    # Input: Read a single string
    input_string = input().strip()

    # Output: Check for consecutive 's' and print the result
    result = check_hiss(input_string)
    print(result)

if __name__ == "__main__":
    main()
