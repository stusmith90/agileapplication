-- Delete from all tables
DELETE FROM TABLE project;
DELETE FROM TABLE backlog;
DELETE FROM TABLE user_story;
DELETE FROM TABLE task;
DELETE FROM TABLE user;
DELETE FROM TABLE task_progress;

-- Insert initial PROJECT
INSERT INTO project 
(
	project_id,
	project_name
)
VALUES 
(
	1,
	'My Project'
);


-- Insert Initial System Admin USER
INSERT INTO user 
(
	user_id,
	username,
	password,
	name,
	role
)
VALUES
(
	0,
	'SysAdmin',
	'Pa55word',
	'System Admin',
	'edu.lmu.bfs.ase2.model.SystemAdmin'
);
  
