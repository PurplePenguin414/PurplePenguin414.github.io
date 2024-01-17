def main():
    # Read the input cards
    cards = input().split()

    # Count the occurrences of each rank
    rank_count = {}
    for card in cards:
        rank = card[0]
        rank_count[rank] = rank_count.get(rank, 0) + 1

    # Find the maximum count
    max_count = 0
    for count in rank_count.values():
        max_count = max(max_count, count)

    print(max_count)

if __name__ == "__main__":
    main()
