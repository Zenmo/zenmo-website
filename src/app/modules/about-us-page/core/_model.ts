import {UserSocialNetworksModel} from "../../auth";

interface  IZenmoMemberModel {
    fullName: string
    profileImage: string
    title: string
    socialNetworks?: UserSocialNetworksModel
}


export type {IZenmoMemberModel}