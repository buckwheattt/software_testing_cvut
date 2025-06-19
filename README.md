# 🧪 Sumerian Records Website Automated Tests

This project contains automated UI tests for the [Sumerian Records](https://www.sumerianrecords.com) website, written in Java using Selenium WebDriver.

## 📁 Project Structure
```
src/
├── main/
│ └── java/
│ └── org.example/ # Entry point (Main.java)
├── resources/
│ ├── csv/ # Test data
│ │ └── csvtesting.csv
│ └── drivers/ # Chrome WebDriver
│ ├── chromedriver.exe
│ └── LICENSE.chromedriver
└── test/
└── java/
├── com.sumerianrecords/ # UI tests
│ ├── EditProfileTest
│ ├── EmptyCartTest
│ ├── MainTest
│ ├── MenuTest
│ ├── OrderConfirmationTest
│ ├── ProductPriceTest
│ ├── ProductSearchTest
│ ├── ShoppingCartTest
│ ├── SignUpTest
│ └── TitleTest
└── csv/
└── CSVReader.java # Class for reading CSV files
```
## 🔧 Technologies
- Java 17+
- Maven (or Gradle)
- Selenium WebDriver
- JUnit
- CSV-based data
- Google Chrome + ChromeDriver

## 🚀 How to Run
1. Install [Java](https://adoptium.net) and [Maven](https://maven.apache.org/)
2. Clone the repository:

```bash
git clone https://github.com/your-username/software_testing_cvut.git
cd software_testing_cvut
```
3.Make sure chromedriver.exe matches your Chrome version.

Run the tests:
```bash
mvn test
```
## ✅ What Is Being Tested:
Page title validation (TitleTest)
User sign-up (SignUpTest)
Cart functionality (ShoppingCartTest, EmptyCartTest)

Product search and pricing (ProductSearchTest, ProductPriceTest)

Navigation and UI elements (MenuTest, MainTest)

Order confirmation (OrderConfirmationTest)

Profile editing (EditProfileTest)

## 📂 Test Data
The file resources/csv/csvtesting.csv contains external test data used in parameterized tests. The class CSVReader.java is responsible for reading the data.

## 📌 Notes
The project was developed as part of a university assignment for software testing (CTU).
All tests are executed on the live version of the Sumerian Records website.
ChromeDriver is included in the project under the drivers/ folder.

## 📄 License
MIT License — feel free to use, fork, and contribute 🙌
