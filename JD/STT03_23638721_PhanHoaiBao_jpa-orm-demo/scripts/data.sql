INSERT INTO departments (dept_id, dept_name, location)
VALUES
    ('D001', 'Information Technology', 'Building A'),
    ('D002', 'Human Resources', 'Building B'),
    ('D003', 'Finance', 'Building C'),
    ('D004', 'Marketing', 'Building D'),
    ('D005', 'Sales', 'Building E'),
    ('D006', 'Research and Development', 'Building F'),
    ('D007', 'Accounting', 'Building C'),
    ('D008', 'Customer Service', 'Building G'),
    ('D009', 'Legal', 'Building H'),
    ('D010', 'Administration', 'Building B');


INSERT INTO projects
(prj_name, budget, start_date, end_date, status)
VALUES
    ('ERP System',              500000000, '2025-01-15', '2025-12-31', 'COMPLETED'),
    ('E-Commerce Platform',    750000000, '2025-06-01', '2026-05-31', 'IN_PROGRESS'),
    ('Mobile Banking',         900000000, '2025-09-01', '2026-08-31', 'IN_PROGRESS'),
    ('HR Management System',   300000000, '2026-01-10', '2026-10-31', 'IN_PROGRESS'),
    ('Customer Portal',        250000000, '2026-02-01', '2026-07-31', 'IN_PROGRESS'),
    ('AI Recommendation',      650000000, '2026-04-01', '2027-03-31', 'PLANNING'),
    ('Data Warehouse',         800000000, '2025-03-01', '2025-11-30', 'COMPLETED'),
    ('Inventory Management',   400000000, '2026-03-15', '2026-12-31', 'PLANNING'),
    ('Cloud Migration',        550000000, '2025-08-01', '2026-06-30', 'COMPLETED'),
    ('Legacy System Upgrade', 150000000, '2025-05-01', '2025-09-30', 'CANCELLED'),
    ('Digital Transformation', 450000000, '2025-07-01', '2026-01-31', 'CANCELLED'),
    ('Cybersecurity Platform', 700000000, '2026-05-01', '2027-04-30', 'PLANNING');


INSERT INTO employees
(emp_name, email, hire_date, dept_id, manager_id)
VALUES
    ('James Anderson',    'james.anderson@company.com',    '2020-01-15', 'D001', NULL),
    ('Emily Johnson',     'emily.johnson@company.com',     '2020-03-20', 'D002', NULL),
    ('Michael Brown',     'michael.brown@company.com',     '2019-07-10', 'D003', NULL),

    ('Sophia Davis',      'sophia.davis@company.com',      '2021-02-01', 'D001', 1),
    ('William Wilson',    'william.wilson@company.com',    '2021-04-15', 'D001', 1),
    ('Olivia Taylor',     'olivia.taylor@company.com',     '2022-01-10', 'D001', 1),

    ('Daniel Moore',      'daniel.moore@company.com',      '2021-06-01', 'D002', 2),
    ('Ava Thompson',      'ava.thompson@company.com',      '2022-03-15', 'D002', 2),

    ('Benjamin Martin',   'benjamin.martin@company.com',   '2020-09-01', 'D003', 3),
    ('Isabella Jackson',  'isabella.jackson@company.com',  '2023-01-10', 'D003', 3),

    ('Alexander White',   'alexander.white@company.com',   '2022-05-20', 'D004', 4),
    ('Mia Harris',        'mia.harris@company.com',        '2023-02-15', 'D004', 4),

    ('Henry Clark',       'henry.clark@company.com',       '2021-08-01', 'D005', 5),
    ('Charlotte Lewis',   'charlotte.lewis@company.com',   '2022-09-10', 'D005', 5),

    ('Daniel Young',      'daniel.young@company.com',      '2020-11-01', 'D006', 6),
    ('Amelia Walker',     'amelia.walker@company.com',     '2023-04-01', 'D006', 6),

    ('Matthew Hall',      'matthew.hall@company.com',      '2021-10-15', 'D007', 9),
    ('Harper Allen',      'harper.allen@company.com',      '2022-12-01', 'D008', 11),

    ('Ethan King',        'ethan.king@company.com',        '2023-05-15', 'D009', 12),
    ('Evelyn Wright',     'evelyn.wright@company.com',     '2024-01-10', 'D010', 13);

INSERT INTO employees_profiles
(emp_id, address, phone, date_of_birth)
VALUES
    (1,  '123 Main Street',   '(212) 555-0101', '1990-03-15'),
    (2,  '456 Oak Avenue',    '(415) 555-0102', '1989-07-22'),
    (3,  '789 Pine Road',     '(312) 555-0103', '1988-11-10'),
    (4,  '12 Maple Street',   '(617) 555-0104', '1992-01-25'),
    (5,  '34 Cedar Avenue',   '(214) 555-0105', '1991-05-18'),
    (6,  '56 Birch Road',     '(305) 555-0106', '1993-09-30'),
    (7,  '78 Elm Street',     '(206) 555-0107', '1990-12-05'),
    (8,  '90 Willow Avenue',  '(202) 555-0108', '1994-02-14'),
    (9,  '15 Lakeview Road',  '(713) 555-0109', '1987-06-20'),
    (10, '27 Hill Street',    '(404) 555-0110', '1995-08-12'),
    (11, '39 River Avenue',   '(617) 555-0111', '1991-10-08'),
    (12, '41 Garden Road',    '(702) 555-0112', '1993-04-27'),
    (13, '53 Park Street',     '(503) 555-0113', '1989-01-19'),
    (14, '65 Forest Avenue',   '(303) 555-0114', '1992-07-03'),
    (15, '77 Green Road',      '(408) 555-0115', '1996-11-25');

INSERT INTO full_time_employees (emp_id, monthly_salary)
VALUES
    (1,  45000000),
    (2,  38000000),
    (3,  42000000),
    (4,  30000000),
    (5,  32000000),
    (6,  28000000),
    (7,  26000000),
    (8,  27000000),
    (9,  35000000),
    (11, 29000000),
    (12, 31000000),
    (13, 34000000),
    (14, 30000000),
    (15, 36000000);


INSERT INTO part_time_employees (emp_id, hourly_rate,hours)
VALUES
    (10, 120000, 5),
    (16, 100000, 15),
    (17, 150000, 51),
    (18, 110000, 25),
    (19, 130000, 55),
    (20,  90000, 35);

INSERT INTO employees_projects (emp_id, prj_id)
VALUES
    (1,  1),
    (1,  2),
    (1,  3),

    (2,  1),
    (2,  4),

    (3,  2),
    (3,  5),
    (3,  7),

    (4,  1),
    (4,  3),

    (5,  2),
    (5,  6),

    (6,  3),
    (6,  4),
    (6,  8),

    (7,  4),

    (8,  5),
    (8,  7),

    (9,  1),
    (9,  6),
    (9,  9),

    (10, 2),
    (10, 5),

    (11, 3),
    (11, 7),

    (12, 4),
    (12, 8),

    (13, 6),
    (13, 9),

    (14, 1),
    (14, 10),

    (15, 3),
    (15, 5);
