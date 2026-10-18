INSERT INTO Customers(customerId, fullName, email, driverLicenseNumber)
VALUES
    ('C001', 'John Smith', 'john.smith@gmail.com', 'B2-790123456789'),
    ('C002', 'Emma Johnson', 'emma.johnson@gmail.com', 'B2-650987654321'),
    ('C003', 'Michael Brown', 'michael.brown@gmail.com', 'C-510112223344'),
    ('C004', 'Sophia Davis', 'sophia.davis@gmail.com', 'B2-790998887777'),
    ('C005', 'Daniel Wilson', 'daniel.wilson@gmail.com', 'D-450223344556'),
    ('C006', 'Olivia Taylor', 'olivia.taylor@gmail.com', 'B2-880112233445'),
    ('C007', 'James Anderson', 'james.anderson@gmail.com', 'C-720998877665'),
    ('C008', 'Isabella Thomas', 'isabella.thomas@gmail.com', 'B2-560123123123'),
    ('C009', 'William Moore', 'william.moore@gmail.com', 'D-940456456456'),
    ('C010', 'Mia Martin', 'mia.martin@gmail.com', 'B2-330789789789');


INSERT INTO Phones(customerId, phone)
VALUES
    ('C001', '0901000001'),
    ('C001', '0911000001'),

    ('C002', '0901000002'),

    ('C003', '0901000003'),
    ('C003', '0911000003'),

    ('C004', '0901000004'),

    ('C005', '0901000005'),
    ('C005', '0911000005'),

    ('C006', '0901000006'),

    ('C007', '0901000007'),

    ('C008', '0901000008'),
    ('C008', '0911000008'),

    ('C009', '0901000009'),

    ('C010', '0901000010');



INSERT INTO Cars
(carId, carName, brand, licensePlate, seatCount, pricePerDay, status)
VALUES
    (1, 'Civic', 'Honda', '51A-11111', 5, 100, 'AVAILABLE'),
    (2, 'City', 'Honda', '51A-11112', 5, 90, 'RENTED'),
    (3, 'Fortuner', 'Toyota', '51A-11113', 7, 180, 'AVAILABLE'),
    (4, 'Camry', 'Toyota', '51A-11114', 5, 150, 'MAINTENANCE'),
    (5, 'Mazda 3', 'Mazda', '51A-11115', 5, 110, 'AVAILABLE'),
    (6, 'CX-5', 'Mazda', '51A-11116', 7, 170, 'RENTED'),
    (7, 'K3', 'Kia', '51A-11117', 5, 95, 'AVAILABLE'),
    (8, 'Seltos', 'Kia', '51A-11118', 5, 130, 'AVAILABLE'),
    (9, 'Mercedes C300', 'Mercedes', '51A-11119', 5, 300, 'RENTED'),
    (10, 'BMW X5', 'BMW', '51A-11120', 7, 350, 'AVAILABLE');


INSERT INTO RentalContracts
(customerId, carId, startDate, endDate, contractStatus)
VALUES

('C001', 1, '2025-01-01', '2025-01-05', 'BOOKED'),
('C002', 5, '2025-04-01', '2025-04-05', 'BOOKED'),
('C003', 10, '2025-06-01', '2025-06-06', 'BOOKED'),
('C004', 3, '2025-07-01', '2025-07-05', 'BOOKED'),
('C008', 7, '2025-06-10', '2025-06-12', 'BOOKED'),

('C001', 8, '2025-03-12', '2025-03-16', 'ACTIVE'),
('C006', 10, '2025-03-18', '2025-03-22', 'ACTIVE'),
('C007', 6, '2025-04-01', '2025-04-06', 'ACTIVE'),
('C009', 9, '2025-04-20', '2025-04-25', 'ACTIVE'),
('C010', 10, '2025-05-01', '2025-05-05', 'ACTIVE'),

('C001', 3, '2025-02-10', '2025-02-15', 'COMPLETED'),
('C002', 2, '2025-01-03', '2025-01-06', 'COMPLETED'),
('C003', 4, '2025-01-15', '2025-01-18', 'COMPLETED'),
('C003', 1, '2025-02-20', '2025-02-25', 'COMPLETED'),
('C004', 6, '2025-01-08', '2025-01-12', 'COMPLETED'),
('C004', 7, '2025-03-01', '2025-03-04', 'COMPLETED'),
('C005', 8, '2025-02-01', '2025-02-03', 'COMPLETED'),
('C005', 5, '2025-03-10', '2025-03-15', 'COMPLETED'),
('C006', 9, '2025-01-20', '2025-01-25', 'COMPLETED'),
('C006', 4, '2025-05-05', '2025-05-07', 'COMPLETED'),
('C007', 1, '2025-02-14', '2025-02-16', 'COMPLETED'),
('C008', 3, '2025-01-25', '2025-01-30', 'COMPLETED'),
('C008', 8, '2025-03-15', '2025-03-18', 'COMPLETED'),
('C009', 2, '2025-02-05', '2025-02-08', 'COMPLETED'),
('C010', 5, '2025-01-11', '2025-01-15', 'COMPLETED'),

('C002', 9, '2025-05-01', '2025-05-03', 'CANCELLED'),
('C005', 2, '2025-04-12', '2025-04-14', 'CANCELLED'),
('C009', 6, '2025-06-15', '2025-06-18', 'CANCELLED');