import requests
from bs4 import BeautifulSoup


Link = input("Enter the amazon link: \n")
X = Link.split('.ca/')[1].split('/dp/')[0]
Y = Link.split('/dp/')[1]
Link = f"https://amazon.ca/{X}/dp/{Y}"


Response = requests.get(Link)
Soup = BeautifulSoup(Response.text, 'html.parser')

Rating = Soup.find('span', {'id': 'acrPopover'}).get('title')
print("Average Rating:", Rating)

UserInput = input("Do you want to see the top 3 reviews? (y/n) \n")
match UserInput:
    case "y" | "Y" | "yes" | "Yes" | "YES":
        Reviews = Soup.find_all('span', {'data-hook': 'review-body'})
        TopReviews = [Review.get_text(strip=True) for Review in Reviews[:3]]
        print("Top 3 Reviews: \n")
        for Review in TopReviews:
            print(Review)
            print("\n")
    case _:
        print("Okay, have a nice day!")

