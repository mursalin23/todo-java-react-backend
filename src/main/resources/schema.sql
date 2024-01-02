CREATE TABLE IF NOT EXISTS Todo (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    dueDate TIMESTAMP,
    priority INTEGER
);

/**
INSERT INTO Todo (description, dueDate, priority) VALUES
('Finish homework', '2019-01-01 12:00:00', 1),
('Go to the gym', '2019-01-01 13:00:00', 2),
('Go to the supermarket', '2019-01-01 14:00:00', 3),
('Go to the cinema', '2019-01-01 15:00:00', 4),
('Go to the theatre', '2019-01-01 16:00:00', 5);
*/