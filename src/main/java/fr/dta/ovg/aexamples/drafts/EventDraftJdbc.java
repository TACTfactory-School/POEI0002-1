//package com.ovg.app.aexamples.drafts;
//
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ovg.app.entities.Event;
//import com.ovg.app.exceptions.NoteYetImplementedException;
//import com.ovg.app.repositories.EventRepository;
//
//public class EventDraftJdbc {
//
//    public EventDraftJdbc() {
//        // This is an empty constructor
//    }
//
//    // ========== EVENT CONTROLLER ===========================
//    @RestController
//    @RequestMapping("event")
//    public class EventController extends CrudController<Event, EventRepository> {
//
//        @Autowired
//        private EventRepository repository;
//
//        @GetMapping("/list")
//        public List<Event> getAll() throws SQLException {
//            return this.repository.findAll();
//        }
//
//        @PutMapping("/add")
//        public void addEvent(@RequestBody Event e) throws SQLException {
//            this.repository.save(e);
//        }
//
//        @DeleteMapping("{id}")
//        public void delEventID(@PathVariable int id) throws SQLException {
//            this.repository.deleteOneByID(id);
//            ;
//        }
//
//        @DeleteMapping("/delByLabel")
//        public void delEventLabel(@PathVariable String label) throws SQLException {
//            if (this.repository.checkLabel(label)) {
//                this.repository.deleteOneByLabel(label);
//            } else {
//                System.out.println("Le label saisi n'existe pas dans la BDD !");
//            }
//        }
//
//        @PutMapping("{id}")
//        public void updateEvent(@PathVariable int id, @RequestBody Event e) throws SQLException {
//            this.repository.updateOne(e, id);
//        }
//
//        @PostMapping
//        public Event create() throws Exception {
//            throw new NoteYetImplementedException();
//        }
//
//        // Injection de la réponse générer par Spring
//        @PostMapping
//        public Event create(HttpServletResponse response) {
//            response.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
//            // https://http.cat
//            return null;
//        }
//
//        // Par le retour de la fonction
//        @PostMapping
//        public ResponseEntity<Event> create1() {
//            return ResponseEntity.ok(new Event());
//            // return
//            // ResponseEntity.of(null).status(HttpStatus.NOT_IMPLEMENTED).build();
//        }
//
//        // Par exception ré-écrite
//        @PostMapping
//        public Event create2() {
//            throw new RuntimeException("Bogué !");
//        }
//
//        @ExceptionHandler(Exception.class)
//        public Map<String, String> errors(Exception e) {
//            return Collections.singletonMap("error", "ça a boogué !");
//        }
//
//        @ExceptionHandler(RuntimeException.class)
//        public Map<String, String> errors(Exception e, HttpServletResponse response) {
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            return Collections.singletonMap("error", e.getMessage());
//        }
//
//        // Par custom exception
//        @PostMapping
//        public Event create() throws Exception {
//            throw new Exception("Bogué !");
//        }
//
//        @ResponseStatus(HttpStatus.BAD_REQUEST)
//        public static class MyException extends Exception {
//            private static final long serialVersionUID = 1L;
//
//            public MyException(final String msg) {
//                super(msg);
//            }
//// ========== ENTITYBASE CONTROLLER ===========================
////          private LocalDateTime createdAt = LocalDateTime.now();
//         /**
//           * @return the createdAt
//           **/
//          public LocalDateTime getCreatedAt() {
//             return createdAt;
//         }
//
//         /**
//           * @param createdAt the createdAt to set
//           */
//          public void setCreatedAt(LocalDateTime createdAt) {
//              this.createdAt = createdAt;
//         }
//
//// ========== ENTITY EVENT ===========================
//        //import com.fasterxml.jackson.annotation.JsonIgnore;
//        //import com.fasterxml.jackson.annotation.JsonProperty;
//        //  @JsonProperty
//        //  private Integer id;
//
//        // Contructor
//
//        public Event() {
//            this(null, null, null);
//        }
//
//        public Event(final String label, final String description,  final String author) {
//            this.label = label;
//            this.description = description;
//            this.author = author;
//        }
//
//
// ================ REPOSITORIES EventRepository ==============
// * CORRECTIF JDBC
// * import com.ovg.app.repositories.OvgRepository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Repository
//public class EventRepository extends OvgRepository<Event> {
//
//    @Override
//    protected String getTableName() {
//        return "app_events";
//    }
//
//    @Override
//    protected List<String> getColumnNames() {
//        return Arrays.asList("id", "label", "event_description", "author");
//    }
//
//    @Override
//    protected PreparedStatement fill(final PreparedStatement stmt, final Event e) throws SQLException {
//        stmt.setInt(1, e.getId());
//        stmt.setString(2, e.getLabel());
//        stmt.setString(3, e.getDescription());
//        stmt.setString(4, e.getAuthor());
//
//        return null;
//    }
//
//    @Override
//    protected Event fill(final ResultSet rs) throws SQLException {
//        final Event result = new Event();
//
//        result.setId(rs.getInt("id"));
//        result.setLabel(rs.getString("label"));
//        result.setDescription(rs.getString("event_description"));
//        result.setAuthor(rs.getString("author"));
//
//        return result;
//    }
//}
///*
// *		// OLD
//        import java.sql.Connection;
//        import java.sql.Statement;
//        import java.util.ArrayList;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.data.jpa.repository.JpaRepository;
//        import org.springframework.data.jpa.repository.Query;
//        import org.springframework.data.repository.query.Param;
// *		EventRepository extends OvgRepository<Event>
// */
//        @Autowired
//        private EntityManager manager;
//
//        private Connection connection() {
//            return this.manager.getConnection();
//        }
//
//        public int getLenght() throws SQLException{
//            final Statement stm = this.connection().createStatement();
//            final String query = String.format("SELECT COUNT(e.id) FROM event e");
//            ResultSet rs = stm.executeQuery(query);
//            rs.next();
//            final int dbLenght = rs.getInt(1);
//            return dbLenght;
//        }
//
//        public boolean checkLabel(String label) throws SQLException{
//            final boolean check;
//            final Statement stm = this.connection().createStatement();
//            final String query = String.format("SELECT e.label FROM event e");
//            if (label.equals(stm.executeUpdate(query))){
//                check = true;
//            } else {
//                check = false;
//            }
//            return check;
//        }
//
//        private void insertOne(String label, String description, String author) throws SQLException {
//            final Statement stm = this.connection().createStatement();
//
//            final String query = String.format("INSERT INTO event (label, event_description, author)"
//                                              + "VALUES (\"%s\", \"%s\", \"%s\")",
//                                                      label, description, author);
//
//            System.out.println("Query: " + query);
//            stm.executeUpdate(query);
//        }
//
//        public void deleteOneByID(final int id) throws SQLException{
//            final Statement stm = this.connection().createStatement();
//            final String query = String.format("DELETE FROM event WHERE id = %d", id);
//            System.out.println("Query: " + query);
//
//            if (stm.executeUpdate(query) == 0) {
//                System.out.println("L'ID saisi n'existe pas dans la BDD !");
//            }
//        }
//
//        public void updateOne(Event e, int id) throws SQLException{
//            final Statement stm = this.connection().createStatement();
//            final String query = String.format("UPDATE event SET `label` = '%s',"
//                                                              + "`event_description` = '%s',"
//                                                              + "`author` = '%s'"
//                                                              + "WHERE id = %d",
//                                                            e.getLabel(),
//                                                            e.getDescription(),
//                                                            e.getAuthor(),
//                                                            id);
//            stm.executeUpdate(query);
//        }
//
//        public void deleteOneByLabel(String label) throws SQLException{
//            final Statement stm = this.connection().createStatement();
//            final String query = String.format("DELETE FROM event e WHERE LOWER(e.label) LIKE '%s'",
//                                                label.toLowerCase());
//            System.out.println("Query: " + query);
//            stm.executeUpdate(query);
//        }
//
//        public List<Event> findAll() throws SQLException {
//            final List<Event> result = new ArrayList<Event>();
//            final Statement stm = connection().createStatement();
//            final String query = "SELECT * FROM event";
//
//            System.out.println("Query: " + query);
//            final ResultSet eventRS = stm.executeQuery(query);
//
//            while (eventRS.next()) {
//                final int id = eventRS.getInt("id");
//                final String label = eventRS.getString("label");
//                final String description = eventRS.getString("event_description");
//                final String author = eventRS.getString("author");
//
//                result.add(new Event(id, label, description, author));
//            }
//            return result;
//        }
//
//        public void save(Event e) throws SQLException{
//            insertOne(e.getLabel(), e.getDescription(), e.getAuthor());
////          return new Event(1, e.getLabel(), e.getDescription(), e.getAuthor());
//        }
//
//// ================ REPOSITORIES EventRepository ==============
////  implements CommandLineRunner
////    	import org.springframework.beans.factory.annotation.Autowired;
////    	import org.springframework.boot.CommandLineRunner;
////    	import com.ovg.app.repositories.EventRepository;
//        @Autowired
//        private EventRepository eventRepository;
//
//        @Override
//        public void run(String... args) throws Exception {
//            // this.userRepository.selectAll(connection);
//        }
//
