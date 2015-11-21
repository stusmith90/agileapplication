-- Create PROJECT table
CREATE TABLE project (
  project_id INT NOT NULL AUTO_INCREMENT,
  project_name TEXT NULL,
  PRIMARY KEY (project_id));


-- Create BACKLOG table
CREATE TABLE backlog (
  backlog_id INT NOT NULL  AUTO_INCREMENT ,
  backlog_type TEXT NOT NULL,
  name TEXT NULL,
  project_id INT NOT NULL DEFAULT 0, 
  start_date DATE NULL,
  end_date DATE NULL,
  PRIMARY KEY (backlog_id));
  

 -- Create USER_STORY table
 CREATE TABLE user_story (
  user_story_id INT NOT NULL,
  backlog_id INT NOT NULL,
  product_owner INT NULL,
  priority INT NULL,
  title TEXT NULL,
  description TEXT NULL,
  acceptance_criteria TEXT NULL,
  story_point_estimate INT NULL,
  PRIMARY KEY (user_story_id));
 
  
 -- Create TASK table
 CREATE TABLE task (
  task_id INT NOT NULL,
  name TEXT NOT NULL,
  description TEXT NULL,
  assigned_to INT NULL,
  estimate INT NULL,
  status TEXT NULL,
  PRIMARY KEY (task_id));

  
 -- Create USER table
 CREATE TABLE user (
  user_id INT NOT NULL,
  username TEXT NOT NULL,
  password TEXT NULL,
  name TEXT NULL,
  role TEXT NULL,
  PRIMARY KEY (user_id));

  
 -- Create TASK_PROGRESS table
 CREATE TABLE task_progress (
  task_progress_id INT NOT NULL,
  task_id INT NOT NULL,
  user_id INT NOT NULL,
  time_spent INT NULL,
  time_remaining INT NULL,
  date DATE NULL,
  PRIMARY KEY (task_progress_id));
  
  