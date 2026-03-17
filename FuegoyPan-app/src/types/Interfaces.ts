
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