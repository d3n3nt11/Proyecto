
    //  Lo que devuelve el login/register
    export interface IAuthResponse {
    token: string;
    }

    //  Lo que enviamos al hacer login
    export interface ILoginRequest {
    name: string;
    password: string;
    }

    //  Lo que enviamos al registrar un usuario
    export interface IRegisterRequest {
    name: string;
    password: string;
    role?: string; // Opcional, por si quieres asignar rol
    }

    // Datos de un usuario (para getMe, por ejemplo)
    export interface IUser {
    id: number;
    name: string;
    role: string;
    profilePhoto?: string;
    }

    // Datos de un producto
    export interface IProducto {
        id: number;
        name: string;
        description: string;
        price: number;
        category: "comida" | "bebida" | "postre" | "salsa";
        imageUrl?: string;
    }
    // Datos de un ingrediente
    export interface IIngrediente {
    id: number;
    nombre: string;
    cantidad: number;
    imageUrl?: string;        // URL de la imagen del ingrediente (opcional)
    unidad: string;           // kg, g, litros, unidades, etc.
    minimo?: number;          // Stock mínimo para alertas (opcional)
    caducidad?: string;       // Fecha de caducidad (opcional, formato YYYY-MM-DD)
}
