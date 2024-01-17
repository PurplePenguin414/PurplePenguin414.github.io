def main():
    # Input: Read the grade limits and the student's score
    a_limit, b_limit, c_limit, d_limit, e_limit = map(int, input().split())
    score = int(input())

    # Determine the grade based on the score
    if score >= a_limit:
        print("A")
    elif score >= b_limit:
        print("B")
    elif score >= c_limit:
        print("C")
    elif score >= d_limit:
        print("D")
    elif score >= e_limit:
        print("E")
    else:
        print("F")

if __name__ == "__main__":
    main()
