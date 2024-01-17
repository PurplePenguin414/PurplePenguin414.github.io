def calculate_scientific_points(cards):
    card_counts = {'T': 0, 'C': 0, 'G': 0}

    for card in cards:
        card_counts[card] += 1

    total_points = 0

    for card_type in card_counts:
        total_points += card_counts[card_type] ** 2

    # Calculate additional points for sets of three different cards
    min_card_count = min(card_counts.values())
    total_points += min_card_count * 7

    return total_points

def main():
    cards = input().strip()  # Input string containing scientific cards
    points = calculate_scientific_points(cards)
    print(points)

if __name__ == "__main__":
    main()
