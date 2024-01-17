class Friend:
    def __init__(self, name, like, birthday):
        self.name = name
        self.like = like
        self.birthday = birthday

    def __lt__(self, other):
        if self.birthday == other.birthday:
            return other.like < self.like
        return self.birthday < other.birthday

def main():
    N = int(input())
    
    friends = []
    
    for _ in range(N):
        friend_data = input().split()
        name = friend_data[0]
        like = int(friend_data[1])
        birthday = friend_data[2]
        friends.append(Friend(name, like, birthday))
    
    friends.sort()

    remembered_friends = [friends[0].name]

    for i in range(1, N):
        if friends[i].birthday != friends[i - 1].birthday:
            remembered_friends.append(friends[i].name)

    print(len(remembered_friends))
    for name in sorted(remembered_friends):
        print(name)

if __name__ == "__main__":
    main()
