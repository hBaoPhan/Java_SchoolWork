-- =========================================================
-- 1. Projects
-- =========================================================

INSERT INTO Projects
    (projectId, name, budget, startDate, endDate, status)
VALUES
    ('P001', 'E-Commerce Platform', 150000.00,
     '2026-01-10', '2026-06-30', 'IN_PROGRESS'),

    ('P002', 'Banking Management System', 280000.00,
     '2026-02-01', '2026-09-30', 'IN_PROGRESS'),

    ('P003', 'Online Learning Platform', 120000.00,
     '2025-08-15', '2026-02-28', 'COMPLETED'),

    ('P004', 'Healthcare Management System', 350000.00,
     '2026-03-01', '2026-12-31', 'PLANNED'),

    ('P005', 'Smart Transportation System', 220000.00,
     '2025-05-01', '2025-12-31', 'COMPLETED'),

    ('P006', 'AI Recommendation System', 450000.00,
     '2026-04-01', '2027-03-31', 'IN_PROGRESS');


-- =========================================================
-- 2. ProjectTechnologies
-- =========================================================

INSERT INTO ProjectTechnologies
    (projectId, technology)
VALUES
    -- P001
    ('P001', 'Java'),
    ('P001', 'Spring Boot'),
    ('P001', 'MySQL'),
    ('P001', 'Docker'),

    -- P002
    ('P002', 'Java'),
    ('P002', 'Spring Boot'),
    ('P002', 'PostgreSQL'),
    ('P002', 'Redis'),

    -- P003
    ('P003', 'Java'),
    ('P003', 'Spring Boot'),
    ('P003', 'MySQL'),
    ('P003', 'React'),

    -- P004
    ('P004', 'Java'),
    ('P004', 'Spring Boot'),
    ('P004', 'PostgreSQL'),
    ('P004', 'Docker'),

    -- P005
    ('P005', 'Python'),
    ('P005', 'FastAPI'),
    ('P005', 'PostgreSQL'),
    ('P005', 'Docker'),

    -- P006
    ('P006', 'Python'),
    ('P006', 'TensorFlow'),
    ('P006', 'PostgreSQL'),
    ('P006', 'Docker');


-- =========================================================
-- 3. Documents
-- =========================================================

INSERT INTO Documents
    (documentId, content, title, type, projectId)
VALUES
    ('D001',
     'System requirements for the e-commerce platform.',
     'E-Commerce Requirements',
     'PDF',
     'P001'),

    ('D002',
     'Database design and entity relationship specification.',
     'E-Commerce Database Design',
     'WORD',
     'P001'),

    ('D003',
     'REST API specification for banking services.',
     'Banking REST API Specification',
     'PDF',
     'P002'),

    ('D004',
     'Security architecture and authentication design.',
     'Banking Security Architecture',
     'POWERPOINT',
     'P002'),

    ('D005',
     'Learning platform functional requirements.',
     'Learning Platform Requirements',
     'WORD',
     'P003'),

    ('D006',
     'Database structure for courses and students.',
     'Learning Database Design',
     'EXCEL',
     'P003'),

    ('D007',
     'Healthcare system requirements and workflows.',
     'Healthcare Requirements',
     'PDF',
     'P004'),

    ('D008',
     'API documentation for healthcare services.',
     'Healthcare API Documentation',
     'WORD',
     'P004'),

    ('D009',
     'Transportation system architecture.',
     'Transportation Architecture',
     'POWERPOINT',
     'P005'),

    ('D010',
     'Vehicle and route database specification.',
     'Transportation Database',
     'EXCEL',
     'P005'),

    ('D011',
     'Recommendation model design and training process.',
     'AI Recommendation Model',
     'PDF',
     'P006'),

    ('D012',
     'Machine learning experiment results.',
     'AI Experiment Results',
     'EXCEL',
     'P006');


-- =========================================================
-- 4. DocumentKeywords
-- =========================================================

INSERT INTO DocumentKeywords
    (documentId, keyword)
VALUES
    -- D001
    ('D001', 'e-commerce'),
    ('D001', 'requirements'),
    ('D001', 'customer'),
    ('D001', 'order'),

    -- D002
    ('D002', 'database'),
    ('D002', 'MySQL'),
    ('D002', 'entity'),
    ('D002', 'relationship'),

    -- D003
    ('D003', 'REST API'),
    ('D003', 'Spring Boot'),
    ('D003', 'banking'),
    ('D003', 'authentication'),

    -- D004
    ('D004', 'security'),
    ('D004', 'authentication'),
    ('D004', 'authorization'),
    ('D004', 'JWT'),

    -- D005
    ('D005', 'education'),
    ('D005', 'course'),
    ('D005', 'student'),
    ('D005', 'learning'),

    -- D006
    ('D006', 'database'),
    ('D006', 'MySQL'),
    ('D006', 'course'),
    ('D006', 'student'),

    -- D007
    ('D007', 'healthcare'),
    ('D007', 'patient'),
    ('D007', 'doctor'),
    ('D007', 'requirements'),

    -- D008
    ('D008', 'REST API'),
    ('D008', 'healthcare'),
    ('D008', 'patient'),
    ('D008', 'authentication'),

    -- D009
    ('D009', 'transportation'),
    ('D009', 'architecture'),
    ('D009', 'vehicle'),
    ('D009', 'route'),

    -- D010
    ('D010', 'database'),
    ('D010', 'vehicle'),
    ('D010', 'route'),
    ('D010', 'PostgreSQL'),

    -- D011
    ('D011', 'AI'),
    ('D011', 'machine learning'),
    ('D011', 'recommendation'),
    ('D011', 'TensorFlow'),

    -- D012
    ('D012', 'AI'),
    ('D012', 'experiment'),
    ('D012', 'machine learning'),
    ('D012', 'TensorFlow');