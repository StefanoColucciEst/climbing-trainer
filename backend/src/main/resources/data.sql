-- Seed grips
INSERT INTO grips (name, category, hand_mode, grip_type, edge_depth_mm, edge_type) VALUES
('Gold standard 20mm', 'HANG', 'TWO_HANDS', 'HALF_CRIMP', 20, 'FLAT'),
('Open hand 20mm', 'HANG', 'TWO_HANDS', 'OPEN_HAND', 20, 'FLAT'),
('Full crimp 10mm', 'HANG', 'TWO_HANDS', 'FULL_CRIMP', 10, 'FLAT'),
('Pinch block 60mm', 'LIFT', 'SINGLE_HAND', 'PINCH', 60, 'FLAT');

-- Seed fingers for grip 1 (4-finger half crimp)
INSERT INTO grip_fingers (grip_id, finger) VALUES (1, 'INDEX'), (1, 'MIDDLE'), (1, 'RING'), (1, 'PINKY');
INSERT INTO grip_fingers (grip_id, finger) VALUES (2, 'INDEX'), (2, 'MIDDLE'), (2, 'RING'), (2, 'PINKY');
INSERT INTO grip_fingers (grip_id, finger) VALUES (3, 'INDEX'), (3, 'MIDDLE'), (3, 'RING'), (3, 'PINKY');
INSERT INTO grip_fingers (grip_id, finger) VALUES (4, 'THUMB'), (4, 'INDEX'), (4, 'MIDDLE'), (4, 'RING'), (4, 'PINKY');

-- Seed assessments
INSERT INTO assessments (grip_id, assessment_type, custom_name) VALUES (1, 'MAX_STRENGTH_7S', NULL);
INSERT INTO assessments (grip_id, assessment_type, custom_name) VALUES (1, 'ENDURANCE_30PCT_HANG', NULL);

-- Seed assessment entries
INSERT INTO assessment_entries (assessment_id, resistance_kg, body_weight_pct, body_weight_kg, recorded_at)
VALUES (1, 25.0, 133.0, 75.0, '2025-03-01T10:00:00');
INSERT INTO assessment_entries (assessment_id, resistance_kg, body_weight_pct, body_weight_kg, recorded_at)
VALUES (1, 27.5, 137.0, 75.0, '2025-03-08T10:00:00');

INSERT INTO assessment_entries (assessment_id, number_of_hangs, time_under_tension_seconds, body_weight_kg, recorded_at)
VALUES (2, 5, 35.0, 75.0, '2025-03-01T10:00:00');

-- Seed conditioning
INSERT INTO conditioning_exercises (name, conditioning_type) VALUES ('Weighted Pull-up', 'PULLUP_1RM');
INSERT INTO conditioning_exercises (name, conditioning_type) VALUES ('Max Pull-ups', 'PULLUP_MAX_REPS');

INSERT INTO conditioning_entries (exercise_id, resistance_kg, body_weight_pct, body_weight_kg, recorded_at)
VALUES (1, 30.0, 140.0, 75.0, '2025-03-01T10:00:00');
INSERT INTO conditioning_entries (exercise_id, max_reps, body_weight_kg, recorded_at)
VALUES (2, 15, 75.0, '2025-03-01T10:00:00');

-- Seed profile
INSERT INTO user_profiles (name, body_weight_kg, streak_days) VALUES ('Climber', 75.0, 12);
