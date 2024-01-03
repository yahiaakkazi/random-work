import csv
import datetime
from faker import Faker

num_records = 3
fake = Faker()

timestamp = datetime.datetime.now().strftime("%Y%m%d%H%M%S")
filename = f"/tmp/nifi_tests/created_csv_files/sample_{timestamp}.csv"

with open(filename, 'w', newline='') as csvfile:
    writer = csv.writer(csvfile)
    writer.writerow(['First Name', 'Last Name', 'Email', 'Age', 'Address'])
    
    for _ in range(num_records):
        first_name = fake.first_name()
        last_name = fake.last_name()
        email = fake.email()
        age = fake.random_int(min=1, max=99)
        address = fake.address().replace('\n', ', ')
        
        writer.writerow([first_name, last_name, email, age, address])
