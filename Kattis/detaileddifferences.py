# Function to compare and print similarities and differences
def compare_strings(s1, s2):
    similarities = []
    differences = []

    for i in range(len(s1)):
        if s1[i] == s2[i]:
            differences.append('.')
        else:
            differences.append('*')

    print(s1)
    print(s2)
    print(''.join(differences))
    print()  # Blank line after each test case

# Main function
def main():
    n = int(input())  # Number of test cases

    for _ in range(n):
        string1 = input()
        string2 = input()

        compare_strings(string1, string2)

if __name__ == "__main__":
    main()
