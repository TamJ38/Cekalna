ALTER TABLE course_preference_history_json
DROP
CONSTRAINT course_preference_history_jso_course_preference_subject_id_fkey;

ALTER TABLE exam_definition_history_json
DROP
CONSTRAINT exam_definition_history_json_exam_definition_id_fkey;

ALTER TABLE teacher_allocation_stats
DROP
CONSTRAINT fk458o59l11uimriau7u5scokh3;

ALTER TABLE teacher_subject_allocations
DROP
CONSTRAINT fk8x5hnrat2qedlefb492ppibq3;

ALTER TABLE teacher_subject_requests
DROP
CONSTRAINT fk9f5twelated1y8ljq9chnlu1h;

ALTER TABLE study_program_accreditation_document
DROP
CONSTRAINT fk_accreditation_document_on_study_program_details;

ALTER TABLE accreditation_study_program_fields
DROP
CONSTRAINT fk_accreditation_studyprogramfields_on_accreditation;

ALTER TABLE company_subscription
DROP
CONSTRAINT fk_companysubscription_on_branded_room_name;

ALTER TABLE company_subscription
DROP
CONSTRAINT fk_companysubscription_on_company;

ALTER TABLE consultation_attendance
DROP
CONSTRAINT fk_consultation_attendance_on_attendee_student_index;

ALTER TABLE consultation_attendance
DROP
CONSTRAINT fk_consultation_attendance_on_consultation;

ALTER TABLE course_rooms
DROP
CONSTRAINT fk_course_room_on_c;

ALTER TABLE course_student_groups
DROP
CONSTRAINT fk_course_student_groups_on_csg;

ALTER TABLE subject_exam
DROP
CONSTRAINT fk_courseexampart_on_session_name;

ALTER TABLE course_preference
DROP
CONSTRAINT fk_coursepreference_on_joinedsubject;

ALTER TABLE disciplinary_decision
DROP
CONSTRAINT fk_disciplinary_decision_on_disciplinary_record;

ALTER TABLE disciplinary_decision
DROP
CONSTRAINT fk_disciplinary_decision_on_disciplinary_sanction;

ALTER TABLE disciplinary_meeting_participant
DROP
CONSTRAINT fk_disciplinary_meeting_participant_meeting;

ALTER TABLE disciplinary_meeting_participant
DROP
CONSTRAINT fk_disciplinary_meeting_participant_professor;

ALTER TABLE disciplinary_record
DROP
CONSTRAINT fk_disciplinary_record_on_course_id;

ALTER TABLE disciplinary_record
DROP
CONSTRAINT fk_disciplinary_record_on_meeting;

ALTER TABLE disciplinary_record
DROP
CONSTRAINT fk_disciplinary_record_on_sanction;

ALTER TABLE disciplinary_record
DROP
CONSTRAINT fk_disciplinaryrecord_on_reporterid;

ALTER TABLE disciplinary_record
DROP
CONSTRAINT fk_disciplinaryrecord_on_studentindex;

ALTER TABLE disciplinary_record
DROP
CONSTRAINT fk_disciplinaryrecord_on_typeid;

ALTER TABLE exam_definition
DROP
CONSTRAINT fk_examdefinition_on_subject_abbreviation;

ALTER TABLE course
DROP
CONSTRAINT fk_joined_subject_group_on_assistant;

ALTER TABLE course
DROP
CONSTRAINT fk_joined_subject_group_on_joined_subject;

ALTER TABLE course
DROP
CONSTRAINT fk_joined_subject_group_on_professor;

ALTER TABLE course
DROP
CONSTRAINT fk_joined_subject_group_on_semester;

ALTER TABLE course_rooms
DROP
CONSTRAINT fk_joined_subject_group_rooms_on_rooms;

ALTER TABLE course_student_groups
DROP
CONSTRAINT fk_joined_subject_group_student_groups_on_sg;

ALTER TABLE joined_subject
DROP
CONSTRAINT fk_joinedsubject_on_subjectid;

ALTER TABLE master_thesis
DROP
CONSTRAINT fk_master_thesis_location_room;

ALTER TABLE master_thesis
DROP
CONSTRAINT fk_masterthesis_on_firstmember;

ALTER TABLE master_thesis
DROP
CONSTRAINT fk_masterthesis_on_mentor;

ALTER TABLE master_thesis
DROP
CONSTRAINT fk_masterthesis_on_secondmember;

ALTER TABLE master_thesis
DROP
CONSTRAINT fk_masterthesis_on_student_student_index;

ALTER TABLE master_thesis_document
DROP
CONSTRAINT fk_masterthesisdocument_on_diplomathesis;

ALTER TABLE master_thesis_status_change
DROP
CONSTRAINT fk_masterthesisstatuschange_on_diplomathesis;

ALTER TABLE master_thesis_status_change
DROP
CONSTRAINT fk_masterthesisstatuschange_on_statuschangedby;

ALTER TABLE memorandum_payment_info
DROP
CONSTRAINT fk_memorandumpaymentinfo_on_company_subscription;

ALTER TABLE professor_engagement
DROP
CONSTRAINT fk_peng_professor;

ALTER TABLE professor_engagement
DROP
CONSTRAINT fk_peng_semester;

ALTER TABLE professor_engagement
DROP
CONSTRAINT fk_peng_subject;

ALTER TABLE professor_academic_titles
DROP
CONSTRAINT fk_professoracademictitles_on_academictitle;

ALTER TABLE professor_academic_titles
DROP
CONSTRAINT fk_professoracademictitles_on_professordetails;

ALTER TABLE professor_details
DROP
CONSTRAINT fk_professordetails_on_id;

ALTER TABLE professor_details
DROP
CONSTRAINT fk_professordetails_on_professoracademictitles;

ALTER TABLE professor_education
DROP
CONSTRAINT fk_professoreducation_on_education;

ALTER TABLE professor_education
DROP
CONSTRAINT fk_professoreducation_on_professordetails;

ALTER TABLE teacher_allocation_stats
DROP
CONSTRAINT fk_sas_semester_code;

ALTER TABLE teacher_allocation_stats
DROP
CONSTRAINT fk_sas_semester_code;

ALTER TABLE scientific_project_call
DROP
CONSTRAINT fk_scientific_project_call_on_programme;

ALTER TABLE scientific_project_member
DROP
CONSTRAINT fk_scientific_project_member_on_project;

ALTER TABLE scientific_project_member
DROP
CONSTRAINT fk_scientific_project_member_on_user;

ALTER TABLE scientific_project
DROP
CONSTRAINT fk_scientific_project_on_call;

ALTER TABLE scientific_project
DROP
CONSTRAINT fk_scientific_project_on_professor;

ALTER TABLE scientific_project
DROP
CONSTRAINT fk_scientific_project_on_programme;

ALTER TABLE scientific_project_programme
DROP
CONSTRAINT fk_scientific_project_programme_on_grant_holder;

ALTER TABLE subject_exam
DROP
CONSTRAINT fk_se_examdef_id;

ALTER TABLE semester_cycle
DROP
CONSTRAINT fk_semester_cycle_on_semester;

ALTER TABLE year_exam_session_cycle
DROP
CONSTRAINT fk_semester_exam_session_cycle_on_semester_exam_session;

ALTER TABLE year_exam_session
DROP
CONSTRAINT fk_semesterexamsession_on_semester_code;

ALTER TABLE study_program_details
DROP
CONSTRAINT fk_spd_coordinator_id;

ALTER TABLE student_subject_enrollment
DROP
CONSTRAINT fk_sse_on_joined_subject;

ALTER TABLE student_subject_enrollment
DROP
CONSTRAINT fk_sse_on_student_groups;

ALTER TABLE student_group
DROP
CONSTRAINT fk_student_group_on_semester;

ALTER TABLE student_subject_enrollment
DROP
CONSTRAINT fk_student_subject_enrollment_course;

ALTER TABLE student_subject_enrollment
DROP
CONSTRAINT fk_student_subject_enrollment_professor;

ALTER TABLE student_equivalence_request
DROP
CONSTRAINT fk_studentequivalencerequest_on_new_study_program_code;

ALTER TABLE student_equivalence_request
DROP
CONSTRAINT fk_studentequivalencerequest_on_old_study_program_code;

ALTER TABLE student_equivalence_request
DROP
CONSTRAINT fk_studentequivalencerequest_on_student_student_index;

ALTER TABLE student_grades
DROP
CONSTRAINT fk_studentgrades_on_student_student_index;

ALTER TABLE student_grades
DROP
CONSTRAINT fk_studentgrades_on_subject;

ALTER TABLE study_program_details_fields
DROP
CONSTRAINT fk_studyprogramdetails_fields_on_study_program_details;

ALTER TABLE study_program_details
DROP
CONSTRAINT fk_studyprogramdetails_on_accreditation_year;

ALTER TABLE study_program_details
DROP
CONSTRAINT fk_studyprogramdetails_on_id;

ALTER TABLE study_program_subject
DROP
CONSTRAINT fk_studyprogramsubject_on_studyprogram;

ALTER TABLE study_program_subject
DROP
CONSTRAINT fk_studyprogramsubject_on_subject;

ALTER TABLE study_program_subject
DROP
CONSTRAINT fk_studyprogramsubject_on_subjectid;

ALTER TABLE study_program_subject_professor
DROP
CONSTRAINT fk_studyprogramsubjectprofessor_on_professor;

ALTER TABLE study_program_subject_professor
DROP
CONSTRAINT fk_studyprogramsubjectprofessor_on_studyprogramsubject;

ALTER TABLE subject_allocation_stats
DROP
CONSTRAINT fk_subjectalocationstats_on_joinedsubject;

ALTER TABLE subject_details_books
DROP
CONSTRAINT fk_subjectdetails_books_on_subject_details;

ALTER TABLE subject_details_elective_books
DROP
CONSTRAINT fk_subjectdetails_elective_books_on_subject_details;

ALTER TABLE subject_details_notes
DROP
CONSTRAINT fk_subjectdetails_notes_on_subject_details;

ALTER TABLE subject_details
DROP
CONSTRAINT fk_subjectdetails_on_accreditation_year;

ALTER TABLE subject_details
DROP
CONSTRAINT fk_subjectdetails_on_id;

ALTER TABLE teacher_subject_requests
DROP
CONSTRAINT fk_teacher_subject_requests_started_exercise_from;

ALTER TABLE teacher_subject_requests
DROP
CONSTRAINT fk_teacher_subject_requests_started_teaching_from;

ALTER TABLE teacher_subject_allocations
DROP
CONSTRAINT fk_teachersubjectalocations_on_joinedsubject;

ALTER TABLE teacher_subject_requests
DROP
CONSTRAINT fk_teachersubjectrequests_on_joinedsubject;

ALTER TABLE topic
DROP
CONSTRAINT fk_topic_on_meeting_meetingnumber;

ALTER TABLE topic
DROP
CONSTRAINT fk_topic_on_mentionedstudent_student_index;

ALTER TABLE topic
DROP
CONSTRAINT fk_topic_on_professor;

ALTER TABLE topic_mentioned_professors
DROP
CONSTRAINT fk_topmenpro_on_professor;

ALTER TABLE topic_mentioned_professors
DROP
CONSTRAINT fk_topmenpro_on_topic;

ALTER TABLE website_posting
DROP
CONSTRAINT fk_websiteposting_on_company;

ALTER TABLE weekly_subject_topic
DROP
CONSTRAINT fk_weeklysubjecttopic_on_subjectdetails;

ALTER TABLE consultation
DROP
CONSTRAINT fkcbmktcrggiuktgxl1k0qiymhd;

ALTER TABLE consultation
DROP
CONSTRAINT fkcidmxf4i6xbgrtjgnp59o1yu3;

ALTER TABLE teacher_subject_allocations
DROP
CONSTRAINT fkmttbk1pjavwwh773g1isf0t4m;

ALTER TABLE teacher_subjects
DROP
CONSTRAINT fkn680sbj5cc0wo9yeajo62gfwb;

ALTER TABLE teacher_subjects
DROP
CONSTRAINT fkn7wxup9twrg8sniabj2p8liqe;

ALTER TABLE joined_subject_history_json
DROP
CONSTRAINT joined_subject_history_json_joined_subject_abbreviation_fkey;

ALTER TABLE master_thesis
DROP
CONSTRAINT master_thesis_coordinator;

ALTER TABLE professor_engagement_history_json
DROP
CONSTRAINT professor_engagement_history_json_professor_engagement_id_fkey;

ALTER TABLE student_semester_enrollment
DROP
CONSTRAINT student_semester_enrollment_on_semester;

ALTER TABLE student_semester_enrollment
DROP
CONSTRAINT student_semester_enrollment_on_student;

ALTER TABLE student_subject_enrollment
DROP
CONSTRAINT student_subject_enrollment_on_semester;

ALTER TABLE student_subject_enrollment
DROP
CONSTRAINT student_subject_enrollment_on_student;

ALTER TABLE student_subject_enrollment
DROP
CONSTRAINT student_subject_enrollment_on_subject;

ALTER TABLE subject_details_history_json
DROP
CONSTRAINT subject_details_history_json_subject_details_id_fkey;

CREATE TABLE number
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    status VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_number PRIMARY KEY (id)
);

CREATE TABLE reservation
(
    id                    VARCHAR(255) NOT NULL,
    student_student_index VARCHAR(255) NOT NULL,
    professor_id          VARCHAR(255) NOT NULL,
    start_date            TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_date              TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    number_id             BIGINT       NOT NULL,
    consultation_id       BIGINT,
    CONSTRAINT pk_reservation PRIMARY KEY (id)
);

ALTER TABLE consultation
    ADD date date;

ALTER TABLE consultation
    ADD location VARCHAR(255);

ALTER TABLE consultation
    ADD time time WITHOUT TIME ZONE;

ALTER TABLE consultation
    ALTER COLUMN date SET NOT NULL;

ALTER TABLE consultation
    ALTER COLUMN location SET NOT NULL;

ALTER TABLE consultation
    ALTER COLUMN time SET NOT NULL;

ALTER TABLE reservation
    ADD CONSTRAINT FK_RESERVATION_ON_CONSULTATION FOREIGN KEY (consultation_id) REFERENCES consultation (id);

ALTER TABLE reservation
    ADD CONSTRAINT FK_RESERVATION_ON_NUMBER FOREIGN KEY (number_id) REFERENCES number (id);

ALTER TABLE reservation
    ADD CONSTRAINT FK_RESERVATION_ON_PROFESSOR FOREIGN KEY (professor_id) REFERENCES professor (id);

ALTER TABLE reservation
    ADD CONSTRAINT FK_RESERVATION_ON_STUDENT_STUDENT_INDEX FOREIGN KEY (student_student_index) REFERENCES student (student_index);

DROP TABLE academic_title CASCADE;

DROP TABLE accreditation CASCADE;

DROP TABLE accreditation_study_program_fields CASCADE;

DROP TABLE company CASCADE;

DROP TABLE company_subscription CASCADE;

DROP TABLE consultation_attendance CASCADE;

DROP TABLE consultation_canceled_dates CASCADE;

DROP TABLE course CASCADE;

DROP TABLE course_preference CASCADE;

DROP TABLE course_preference_history_json CASCADE;

DROP TABLE course_rooms CASCADE;

DROP TABLE course_student_groups CASCADE;

DROP TABLE disciplinary_decision CASCADE;

DROP TABLE disciplinary_meeting CASCADE;

DROP TABLE disciplinary_meeting_participant CASCADE;

DROP TABLE disciplinary_record CASCADE;

DROP TABLE disciplinary_sanction CASCADE;

DROP TABLE disciplinary_type CASCADE;

DROP TABLE education CASCADE;

DROP TABLE exam_definition CASCADE;

DROP TABLE exam_definition_history_json CASCADE;

DROP TABLE grant_holder CASCADE;

DROP TABLE joined_subject CASCADE;

DROP TABLE joined_subject_history_json CASCADE;

DROP TABLE master_thesis CASCADE;

DROP TABLE master_thesis_document CASCADE;

DROP TABLE master_thesis_status_change CASCADE;

DROP TABLE memorandum_payment_info CASCADE;

DROP TABLE professor_academic_titles CASCADE;

DROP TABLE professor_details CASCADE;

DROP TABLE professor_education CASCADE;

DROP TABLE professor_engagement CASCADE;

DROP TABLE professor_engagement_history_json CASCADE;

DROP TABLE professor_resume CASCADE;

DROP TABLE scientific_project CASCADE;

DROP TABLE scientific_project_call CASCADE;

DROP TABLE scientific_project_member CASCADE;

DROP TABLE scientific_project_programme CASCADE;

DROP TABLE semester CASCADE;

DROP TABLE semester_cycle CASCADE;

DROP TABLE student_equivalence_request CASCADE;

DROP TABLE student_grades CASCADE;

DROP TABLE student_group CASCADE;

DROP TABLE student_semester_enrollment CASCADE;

DROP TABLE student_subject_enrollment CASCADE;

DROP TABLE study_program_accreditation_document CASCADE;

DROP TABLE study_program_details CASCADE;

DROP TABLE study_program_details_fields CASCADE;

DROP TABLE study_program_subject CASCADE;

DROP TABLE study_program_subject_professor CASCADE;

DROP TABLE subject CASCADE;

DROP TABLE subject_allocation_stats CASCADE;

DROP TABLE subject_details CASCADE;

DROP TABLE subject_details_books CASCADE;

DROP TABLE subject_details_elective_books CASCADE;

DROP TABLE subject_details_history_json CASCADE;

DROP TABLE subject_details_notes CASCADE;

DROP TABLE subject_exam CASCADE;

DROP TABLE subject_name_mapping CASCADE;

DROP TABLE teacher_allocation_stats CASCADE;

DROP TABLE teacher_subject_allocations CASCADE;

DROP TABLE teacher_subject_requests CASCADE;

DROP TABLE teacher_subjects CASCADE;

DROP TABLE teaching_and_scientific_meeting CASCADE;

DROP TABLE topic CASCADE;

DROP TABLE topic_mentioned_professors CASCADE;

DROP TABLE website_posting CASCADE;

DROP TABLE weekly_subject_topic CASCADE;

DROP TABLE year_exam_session CASCADE;

DROP TABLE year_exam_session_cycle CASCADE;

ALTER TABLE consultation
DROP
COLUMN end_time;

ALTER TABLE consultation
DROP
COLUMN one_time_date;

ALTER TABLE consultation
DROP
COLUMN professor_id;

ALTER TABLE consultation
DROP
COLUMN room_name;

ALTER TABLE consultation
DROP
COLUMN start_time;

ALTER TABLE consultation
DROP
COLUMN status;

ALTER TABLE consultation
DROP
COLUMN weekly_day_of_week;

DROP SEQUENCE change_study_program_student_request_seq CASCADE;

DROP SEQUENCE company_subscription_seq CASCADE;

DROP SEQUENCE completed_student_semester_evaluation_seq CASCADE;

DROP SEQUENCE consultation_seq CASCADE;

DROP SEQUENCE course_enrollment_without_requirements_student_request_seq CASCADE;

DROP SEQUENCE course_group_change_student_request_seq CASCADE;

DROP SEQUENCE course_professor_evaluation_seq CASCADE;

DROP SEQUENCE course_seq CASCADE;

DROP SEQUENCE diploma_thesis_seq CASCADE;

DROP SEQUENCE diploma_thesis_status_change_seq CASCADE;

DROP SEQUENCE disciplinary_decision_seq CASCADE;

DROP SEQUENCE disciplinary_meeting_participant_seq CASCADE;

DROP SEQUENCE disciplinary_meeting_seq CASCADE;

DROP SEQUENCE disciplinary_record_seq CASCADE;

DROP SEQUENCE disciplinary_sanction_seq CASCADE;

DROP SEQUENCE general_student_request_seq CASCADE;

DROP SEQUENCE installment_payment_student_request_seq CASCADE;

DROP SEQUENCE late_course_enrollment_student_request_seq CASCADE;

DROP SEQUENCE master_thesis_document_seq CASCADE;

DROP SEQUENCE master_thesis_seq CASCADE;

DROP SEQUENCE master_thesis_status_change_seq CASCADE;

DROP SEQUENCE memorandum_payment_info_seq CASCADE;

DROP SEQUENCE request_session_seq CASCADE;

DROP SEQUENCE results_sequence CASCADE;

DROP SEQUENCE scientific_project_call_seq CASCADE;

DROP SEQUENCE scientific_project_member_seq CASCADE;

DROP SEQUENCE scientific_project_programme_seq CASCADE;

DROP SEQUENCE scientific_project_seq CASCADE;

DROP SEQUENCE student_courses_seq CASCADE;

DROP SEQUENCE student_group_seq CASCADE;

DROP SEQUENCE study_program_accreditation_document_seq CASCADE;

DROP SEQUENCE study_program_subject_professor_seq CASCADE;

DROP SEQUENCE study_program_subject_seq CASCADE;

DROP SEQUENCE teacher_subject_allocations_seq CASCADE;

DROP SEQUENCE teacher_subject_requests_seq CASCADE;

DROP SEQUENCE teacher_subjects_seq CASCADE;

DROP SEQUENCE topic_seq CASCADE;

DROP SEQUENCE website_posting_seq CASCADE;

DROP SEQUENCE weekly_subject_topic_seq CASCADE;

CREATE SEQUENCE IF NOT EXISTS consultation_id_seq;
ALTER TABLE consultation
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE consultation
    ALTER COLUMN id SET DEFAULT nextval('consultation_id_seq');

ALTER SEQUENCE consultation_id_seq OWNED BY consultation.id;

ALTER TABLE consultation
    ALTER COLUMN type SET NOT NULL;