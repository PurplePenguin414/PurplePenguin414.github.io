def most_likely_outcomes(N, M):
    # Initialize a dictionary to store the frequency of each possible sum
    sum_frequency = {}

    # Calculate the frequency of each sum
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            total = i + j
            if total in sum_frequency:
                sum_frequency[total] += 1
            else:
                sum_frequency[total] = 1

    # Find the maximum frequency
    max_frequency = max(sum_frequency.values())

    # Collect the most likely outcomes with the maximum frequency
    most_likely_outcomes = [k for k, v in sum_frequency.items() if v == max_frequency]

    return sorted(most_likely_outcomes)

def main():
    N, M = map(int, input().split())
    result = most_likely_outcomes(N, M)

    # Print the most likely outcomes, one per line
    for outcome in result:
        print(outcome)

if __name__ == "__main__":
    main()
