
    //  Lo que devuelve el login/register
    export interface IAuthResponse {
    token: string;
    role: string;
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
    export interface IIngredient {
        ingredientId: number;
        ingredientName: string;
        currentStock: number;
        minStock: number;
        expirationDate?: string;
        unit?: string;
        imageUrl?: string;
    }
