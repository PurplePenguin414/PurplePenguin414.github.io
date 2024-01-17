def calculate_largest_piece_volume(n, h, v):
    # Calculate the volumes of the four pieces
    piece1 = h * v * 4
    piece2 = h * (n - v) * 4
    piece3 = (n - h) * v * 4
    piece4 = (n - h) * (n - v) * 4

    # Find the maximum volume among the four pieces
    largest_piece_volume = max(piece1, piece2, piece3, piece4)

    return largest_piece_volume

def main():
    n, h, v = map(int, input().split())
    largest_piece_volume = calculate_largest_piece_volume(n, h, v)
    print(largest_piece_volume)

if __name__ == "__main__":
    main()
