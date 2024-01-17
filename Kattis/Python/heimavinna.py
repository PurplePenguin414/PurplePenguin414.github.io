def calculate_total_problems(problem_string):
    ranges = problem_string.split(';')
    total_problems = 0

    for problem_range in ranges:
        if '-' in problem_range:
            start, end = map(int, problem_range.split('-'))
            total_problems += end - start + 1
        else:
            total_problems += 1

    return total_problems

def main():
    # Input: Read a single line specifying the problems
    problem_string = input().strip()

    # Calculate the total number of problems
    total_problems = calculate_total_problems(problem_string)

    # Output: Print the total number of problems
    print(total_problems)

if __name__ == "__main__":
    main()
