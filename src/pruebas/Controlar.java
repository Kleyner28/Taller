/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Controlar {

    //Persona classroom[] = new Persona[2];
    ArrayList<Persona> users = new ArrayList();
    Validacion v = new Validacion();
    Persona p = new Persona();
    MasaCorporal mc = new MasaCorporal();

    public Controlar() {

        this.loadMenu();

    }

    //Load menú
    private void loadMenu() {

        try {

            int op = Integer.parseInt(JOptionPane.showInputDialog(null, "------"
                    + "-"
                    + "Menú-------\n"
                    + "1.Agregar registro\n"
                    + "2.Mostrar registro\n"
                    + "3.Borrar todo el registro\n"
                    + "4.Modificar mis datos\n"
                    + "5.Eliminar mis datos\n"
                    + "6.Verificar registro\n"
                    + "7.Historial Indice de masa corporal\n"
                    + "8.Salir\n"
                    + "Digite una opcion", "HOSPITAL GENERAL",
                    JOptionPane.PLAIN_MESSAGE));

            this.optionSelected(op);

        } catch (HeadlessException | NumberFormatException e) {
            this.loadMenu();
            JOptionPane.showMessageDialog(null, "Opcion no valida", "HOSPITAL "
                    + "GENERAL", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Options
    private void optionSelected(int op) {
        try {

            switch (op) {

                case 1:

                    this.arrayListCreate();

                    break;

                case 2:

                    this.showAllArraryList();

                    break;

                case 3:

                    this.deleteAllArrayList();

                    break;

                case 4:

                    this.modifySelectedPerson(Integer.parseInt(JOptionPane.
                            showInputDialog(null, "Digite numero de "
                                    + "identificacion", "HOSPITAL GENERAL",
                                    JOptionPane.QUESTION_MESSAGE)));
                    break;

                case 5:

                    this.deleteSelectedPerson(Integer.parseInt(JOptionPane.
                            showInputDialog(null, "Digite numero de "
                                    + "identificacion", "HOSPITAL GENERAL",
                                    JOptionPane.QUESTION_MESSAGE)));

                    break;

                case 6:

                    this.verifyRegisteredPerson(Integer.parseInt(JOptionPane.
                            showInputDialog(null, "Digite numero de "
                                    + "identificacion", "HOSPITAL GENERAL",
                                    JOptionPane.QUESTION_MESSAGE)));
                    break;

                case 7:

                    this.registerIMC(Integer.parseInt(JOptionPane.
                            showInputDialog(null, "Digite numero de "
                                    + "identificacion", "HOSPITAL GENERAL",
                                    JOptionPane.QUESTION_MESSAGE)));
                    break;

                case 8:
                    int opt = JOptionPane.showConfirmDialog(null, "¿Estas "
                            + "seguro de salir?", "HOSPITAL GENERAL",
                            JOptionPane.YES_NO_OPTION);
                    if (opt == 1) {
                        this.loadMenu();
                    }
                    System.exit(0);

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Opcion no disponible",
                            "HOSPITAL GENERAL", JOptionPane.ERROR_MESSAGE);

                    this.loadMenu();
            }

        } catch (HeadlessException | NumberFormatException e) {
        }
    }

    //Method for create Arraylist
    private void arrayListCreate() {

        try {
            int op;
            do {

                v.getValidateIdPerson(JOptionPane.showInputDialog(null, "Digite "
                        + "su identificación", "HOSPITAL GENERAL",
                        JOptionPane.QUESTION_MESSAGE));

                for (int i = 0; i < users.size(); i++) {
                    while (v.getIdentification() == users.get(i).getIdentificacion()) {
                        JOptionPane.showMessageDialog(null, "Usted ya se encuentra "
                                + "registrado", "HOSPITAL GENERAL",
                                JOptionPane.PLAIN_MESSAGE);
                        v.getValidateIdPerson(JOptionPane.showInputDialog(null, "Digite "
                                + "su identificación", "HOSPITAL GENERAL",
                                JOptionPane.QUESTION_MESSAGE));
                    }
                }

                v.ValidateNamePerson(JOptionPane.showInputDialog(null, "Digite "
                        + "su nombre", "HOSPITAL GENERAL",
                        JOptionPane.QUESTION_MESSAGE));
                v.ValidateLastNamePerson(JOptionPane.showInputDialog(null,
                        "Digite su apellido", "HOSPITAL GENERAL",
                        JOptionPane.QUESTION_MESSAGE));
                v.validateDatePerson(JOptionPane.showInputDialog(null, "Digite su "
                        + "fecha de nacimiento", "HOSPITAL GENERAL",
                        JOptionPane.QUESTION_MESSAGE));

                users.add(new Persona(v.getValidateNamePerson(),
                        v.getValidateLastNamePerson(), v.getIdentification(),
                        String.valueOf(v.getDate())));

                op = JOptionPane.showConfirmDialog(null, "Desea registrar mas "
                        + "usuarios", "HOSPITAL GENERAL",
                        JOptionPane.YES_NO_OPTION);

            } while (op == 0);

            this.loadMenu();

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verifique que los datos sean "
                    + "correctos", "HOSPITAL GENERAL",
                    JOptionPane.PLAIN_MESSAGE);
            this.loadMenu();
        }
    }

    //Method for show ArrayList
    private void showAllArraryList() {

        try {
            if (users.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún "
                        + "registro", "HOSPITAL GENERAL",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            for (int i = 0; i < users.size(); i++) {

                System.out.println("--------------------");
                System.out.println("Nombre: " + users.get(i).
                        getNombres() + "\n"
                        + "Apellido: " + users.get(i).getApellidos() + "\n"
                        + "Identificación: " + users.get(i).
                                getIdentificacion() + "\n"
                        + "Fecha de nacimiento: "
                        + users.get(i).getFecha_nacimiento() + "\n"
                        + "Edad: " + users.get(i).getEdadPerson());
                System.out.println("--------------------");

                JOptionPane.showMessageDialog(null, "Nombre: " + users.get(i).
                        getNombres().toUpperCase() + "\n"
                        + "Apellido: " + users.get(i).getApellidos().
                                toUpperCase() + "\n"
                        + "Identificación: " + users.get(i).
                                getIdentificacion() + "\n"
                        + "Fecha de nacimiento: "
                        + users.get(i).getFecha_nacimiento() + "\n"
                        + "Edad: " + users.get(i).getEdadPerson(),
                        "HOSPITAL GENERAL"
                        + "", JOptionPane.PLAIN_MESSAGE);

            }

            this.loadMenu();

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verifique que los datos sean "
                    + "correctos", "HOSPITAL GENERAL",
                    JOptionPane.PLAIN_MESSAGE);
            this.loadMenu();
        }
    }

    //Method for delete all arrayList
    private void deleteAllArrayList() {

        try {

            if (users.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No hay registros para "
                        + "borrar",
                        "HOSPITAL GENERAL", JOptionPane.INFORMATION_MESSAGE);

            }

            for (int i = 0; i < users.size(); i++) {

                int op = JOptionPane.showConfirmDialog(null,
                        "¿Desea borrar todos los registros", "HOSPITAL GENERAL",
                        JOptionPane.YES_NO_OPTION);

                if (op == 0) {
                    users.clear();

                    System.out.println("ArrayList borrado");

                    JOptionPane.showMessageDialog(null, "Registros borrados",
                            "HOSPITAL GENERAL",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

            this.loadMenu();

        } catch (HeadlessException e) {
            this.loadMenu();
        }

    }

    //Method for modify a selected person
    private void modifySelectedPerson(int a) {

        String[] op = {"Nombre", "Apellido", "Identificación",
            "Fecha de nacimiento", "Cancelar"};

        try {

            a = v.getValidateIdPerson(String.valueOf(a));

            if (users.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No hay registros para "
                        + "modificar",
                        "HOSPITAL GENERAL", JOptionPane.ERROR_MESSAGE);
            }

            for (int i = 0; i < users.size(); i++) {

                if (a == users.get(i).getIdentificacion()) {

                    int select = JOptionPane.showOptionDialog(null, "¿Que "
                            + "datos desea cambiar?", "HOSPITAL GENERAL",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

                    switch (select) {
                        case 0:
                            users.get(i).setNombres(JOptionPane.
                                    showInputDialog(null,
                                            "Digite su nuevo nombre",
                                            "HOSPITAL GENERAL",
                                            JOptionPane.DEFAULT_OPTION));
                            break;
                        case 1:
                            users.get(i).setApellidos(JOptionPane.
                                    showInputDialog(null,
                                            "Digite su nuevo apellido"
                                            + "HOSPITAL GENERAL",
                                            JOptionPane.DEFAULT_OPTION));
                            break;
                        case 2:
                            users.get(i).setIdentificacion(Integer.
                                    parseInt(JOptionPane.showInputDialog(null,
                                            "Digite su nueva identifiación",
                                            "HOSPITAL GENERAL",
                                            JOptionPane.DEFAULT_OPTION)));
                            break;
                        case 3:
                            users.get(i).setFecha_nacimiento(JOptionPane.
                                    showInputDialog(null, "Digite su nueva "
                                            + "fecha de nacimiento",
                                            "HOSPITAL GENERAL",
                                            JOptionPane.DEFAULT_OPTION));
                            break;
                        case 4:
                            this.loadMenu();
                        default:
                            break;
                    }
                } else if (a != users.get(i).getIdentificacion()) {
                    JOptionPane.showMessageDialog(null, "Usted no ha sido "
                            + "registrado", "HOSPITAL GENERAL",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

            this.loadMenu();

        } catch (HeadlessException | NumberFormatException e) {
            this.loadMenu();
        }

    }

    //Method for delete a selected person
    private void deleteSelectedPerson(int b) {

        try {

            b = v.getValidateIdPerson(String.valueOf(b));

            if (users.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No hay registros para "
                        + "borrar",
                        "HOSPITAL GENERAL", JOptionPane.ERROR_MESSAGE);
            }

            for (int i = 0; i < users.size(); i++) {

                if (b == users.get(i).getIdentificacion()) {

                    int opt = JOptionPane.showConfirmDialog(null, "¿Estas "
                            + "seguro de borrar todos tus datos?",
                            "HOSPITAL GENERAL",
                            JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        users.remove(i);
                    }
                } else if (b != users.get(i).getIdentificacion()) {
                    JOptionPane.showMessageDialog(null, "Usted no ha sido "
                            + "registrado", "HOSPITAL GENERAL",
                            JOptionPane.WARNING_MESSAGE);

                }

            }

            this.loadMenu();

        } catch (HeadlessException e) {
            this.loadMenu();
        }

    }

    //Method for verify the people registered
    private void verifyRegisteredPerson(int c) {

        try {

            c = v.getValidateIdPerson(String.valueOf(c));

            if (users.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No hay usuarios "
                        + "registrados",
                        "HOSPITAL GENERAL", JOptionPane.ERROR_MESSAGE);
            }

            for (int i = 0; i < users.size(); i++) {

                if (c == users.get(i).getIdentificacion()) {
                    JOptionPane.showMessageDialog(null, "Usted se encuentra "
                            + "registrado \n"
                            + "Datos\n"
                            + "Nombre: " + users.get(i).getNombres().
                                    toUpperCase() + "\n"
                            + "Apellidos: " + users.get(i).
                                    getApellidos().toUpperCase() + "\n"
                            + "Identificación: " + users.get(i).
                                    getIdentificacion() + "\n"
                            + "Fecha de nacimiento: " + users.get(i).
                                    getFecha_nacimiento() + "\n"
                            + "Edad: " + users.get(i).getEdadPerson(), "HOSPITAL "
                            + "GENERAL", JOptionPane.PLAIN_MESSAGE);

                } else if (c != users.get(i).getIdentificacion()) {
                    JOptionPane.showMessageDialog(null, "Usted no ha sido "
                            + "registrado", "HOSPITAL GENERAL",
                            JOptionPane.WARNING_MESSAGE);
                }

            }

            this.loadMenu();

        } catch (HeadlessException e) {
            this.loadMenu();
        }

    }

    //Method for register Muscle mass index (IMC)
    private void registerIMC(int a) {
        try {

            a = v.getValidateIdPerson(String.valueOf(a));

            if (users.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No hay usuarios "
                        + "registrados",
                        "HOSPITAL GENERAL", JOptionPane.ERROR_MESSAGE);
            }

            for (int i = 0; i < users.size(); i++) {

                if (a == users.get(i).getIdentificacion()) {

                    int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "---Historial--- \n"
                            + "1.Registrar masa corporal\n"
                            + "2.Ver Indice de masa corporal\n"
                            + "3. Regresar\n"
                            + "Digite una de las opciones",
                            "HOSPITAL GENERAL"
                            + "", JOptionPane.PLAIN_MESSAGE));

                    switch (op) {

                        case 1:

                            String[] mes = {"Enero", "Febrero", "Marzo", "Abril"
                                + "",
                                "Mayo", "Junio", "Julio", "Agosto", "Septiembre"
                                + "",
                                "Octubre", "Noviembre", "Diciembre"};

                            ImageIcon icon = new ImageIcon("C:\\Users\\User\\"
                                    + "Pictures\\calendario.png");

                            users.get(i).historial.add(new MasaCorporal(Double.
                                    parseDouble(JOptionPane.
                                            showInputDialog(null,
                                                    "Digite su peso (Kilogramos)"
                                                    + "", "HOSPITAL GENERAL",
                                                    JOptionPane.QUESTION_MESSAGE)),
                                    Double.parseDouble(JOptionPane.
                                            showInputDialog(null, "Digite su"
                                                    + " altura (Metros)",
                                                    "HOSPITAL" + " GENERAL",
                                                    JOptionPane.QUESTION_MESSAGE
                                            )), String.valueOf(JOptionPane.
                                            showInputDialog(null,
                                                    "Seleccione un mes",
                                                    "HOSPITAL GENERAL",
                                                    JOptionPane.DEFAULT_OPTION,
                                                    icon, mes, mes[0]))));

                            this.registerIMC(a);

                            break;

                        case 2:
                            if (users.get(i).historial.isEmpty()) {

                                JOptionPane.showMessageDialog(null, "No ha "
                                        + "registrado sus datos",
                                        "HOSPITAL GENERAL",
                                        JOptionPane.ERROR_MESSAGE);

                                this.registerIMC(a);

                            } else {

                                for (int j = 0; j < users.get(i).historial.size(); j++) {

                                    JOptionPane.showMessageDialog(null,
                                            "Nombre: "
                                            + users.get(i).getNombres() + "\n"
                                            + "Apellido: " + users.get(i).
                                                    getApellidos() + "\n"
                                            + "Peso: " + users.get(i).historial.
                                                    get(j).getPeso() + " kg\n"
                                            + "Altura: "
                                            + users.get(i).historial
                                                    .get(j).getAltura() + " metros\n"
                                            + "Mes: " + users.get(i).historial.
                                                    get(j).getMes() + "\n"
                                            + "IMC: " + users.get(i).historial.
                                                    get(j).calculateIMC() + "\n"
                                            + "Descripción: "
                                            + users.get(i).historial.
                                                    get(j).descriptionIMC());
                                }
                                this.registerIMC(a);

                                break;
                            }

                        case 3:

                            this.loadMenu();

                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opcion no valida",
                                    "HOSPITAL " + "GENERAL",
                                    JOptionPane.ERROR_MESSAGE);
                            break;

                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Usted no ha sido registrado",
                            "HOSPITAL " + "GENERAL",
                            JOptionPane.ERROR_MESSAGE);

                }
            }

            this.loadMenu();

        } catch (HeadlessException | NumberFormatException e) {
            this.loadMenu();
        }

    }
    
}
